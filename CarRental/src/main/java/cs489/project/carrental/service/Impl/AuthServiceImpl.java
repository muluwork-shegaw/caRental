package cs489.project.carrental.service.Impl;

import cs489.project.carrental.DTO.User.BasicUserDto;
import cs489.project.carrental.DTO.auth.UserRequest;
import cs489.project.carrental.DTO.auth.UserResponse;
import cs489.project.carrental.model.domain.User;
import cs489.project.carrental.repository.UserRepo;
import cs489.project.carrental.service.AuthService;
import cs489.project.carrental.utility.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UserRepo userRepo;


    @Override
    public UserResponse login(UserRequest loginRequest) {

        Authentication result = null;
        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());

        final String accessToken = jwtUtil.generateToken(userDetails.getUsername());
//        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());

        User user = userRepo.findByEmail(userDetails.getUsername()).get();

        BasicUserDto basicUser = BasicUserDto.builder()
                .id(user.getId())
                .fName(user.getFName())
                .lName(user.getLName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();

        var userResponse = new UserResponse(accessToken, "refreshToken", basicUser);
        return userResponse;
    }


}
