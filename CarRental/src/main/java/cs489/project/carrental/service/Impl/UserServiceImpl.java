package cs489.project.carrental.service.Impl;

import cs489.project.carrental.DTO.User.BasicUserDto;
import cs489.project.carrental.DTO.User.UserDto;
import cs489.project.carrental.model.domain.User;
import cs489.project.carrental.repository.RoleRepository;
import cs489.project.carrental.repository.UserRepo;
import cs489.project.carrental.security.APIUserDetails;
import cs489.project.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {


    private final BCryptPasswordEncoder pwdEncoder;
    private final UserRepo userRepository;
    private final RoleRepository roleRepo;
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User createUser(UserDto user) {

//        if(user.getRoles().isEmpty()){
//            user.addRole(roleRepo.getByName("Creator"));
//        }
        user.setPassword(pwdEncoder.encode(user.getPassword()));
        User newUser = modelMapper.map(user, User.class);
        newUser.addRole(roleRepo.getByName("customer"));
        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(Long id, UserDto user) {

        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(pwdEncoder.encode(user.getPassword()));
            existingUser.setFName(user.getFName());
            existingUser.setLName(user.getLName());
            return userRepository.save(existingUser);
        }

        throw new NoSuchElementException("User Not Found.");
    }

    @Override
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    public Optional<User> findUserByEmail(String userName) {
        return userRepository.findByEmail(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> opt = findUserByEmail(email);
        User user = opt.get();
        if (opt.isEmpty()) {
            throw new UsernameNotFoundException(" user doesn't exist");
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getRoles().stream()
                        .flatMap(role -> role.getPermissions().stream())
                        .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                        .collect(Collectors.toSet()));

        APIUserDetails customUserDetails = new APIUserDetails(userDetails);
        customUserDetails.setId(user.getId());

        return customUserDetails;
    }

    @Override
    public BasicUserDto getCurrentUser() {
        var User = getUserFromContext();
        return modelMapper.map(User, BasicUserDto.class);
    }

    @Override
    public List<User> getRecentUsers(Integer limit) {
        return userRepository.getRecentUsers().stream().limit(limit).toList();
    }

    @Override
    public User setRole(Long id, List<Long> roleIds) {

        User user = getUserById(id);
        var roles = roleRepo.findAllById(roleIds);
        user.setRoles(null);
        userRepository.save(user);
        user.setRoles(roles);
        return userRepository.save(user);

    }

    @Override
    public BasicUserDto getUserByID(Long id) {
        var user = userRepository.findById(id);
        if (user.isPresent()) {
            return BasicUserDto.builder()
                    .roles(user.get().getRoles())
                    .fName(user.get().getFName())
                    .lName(user.get().getLName())
                    .phoneNumber(user.get().getPhoneNumber())
                    .email(user.get().getEmail())
                    .password(user.get().getPassword())
                    .id(user.get().getId()).build();

        }

        throw new NoSuchElementException("User not found");
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    public User getUserFromContext() {
        var context = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (context.equals("anonymousUser"))
            return null;

        User foundUser = modelMapper.map(context, User.class);

        var user = userRepo.findById(foundUser.getId());
        return user.get();
    }
}