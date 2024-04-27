package cs489.project.carrental.service;

import cs489.project.carrental.DTO.User.BasicUserDto;
import cs489.project.carrental.DTO.User.UserDto;
import cs489.project.carrental.model.domain.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(UserDto user);

    User updateUser(Long id, UserDto user);

    void deleteUser(Long id);


    BasicUserDto getCurrentUser();

    List<User> getRecentUsers(Integer limit);

    User setRole(Long id, List<Long> roleIds);

    BasicUserDto getUserByID(Long id);

    User getUserByEmail(String email);
}

