package cs489.project.carrental.service;


import cs489.project.carrental.DTO.auth.UserRequest;
import cs489.project.carrental.DTO.auth.UserResponse;


public interface AuthService {
    UserResponse login(UserRequest loginRequest);
//    UserResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
