package cs489.project.carrental.controller;

import cs489.project.carrental.DTO.User.UserDto;
import cs489.project.carrental.DTO.auth.UserRequest;
import cs489.project.carrental.DTO.auth.UserResponse;
import cs489.project.carrental.model.domain.User;
import cs489.project.carrental.service.AuthService;
import cs489.project.carrental.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uaa")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin
public class UaaController {
    private final AuthService authService;
    private final UserService userService;


    @PostMapping("/login")

    public ResponseEntity<UserResponse> login(@RequestBody UserRequest loginRequest) {
        System.out.println("loginRequest >>>>>> >>>>>> >>>>>>" +
                " >>>>>> >>>>>> >>>>>> >>>>>> >>>>>>"
                + loginRequest.getEmail() + " " + loginRequest.getPassword());

        UserResponse loginResponse = authService.login(loginRequest);
        System.out.println("token >>>>>> >>>>>> >>>>>>" +
                " >>>>>> >>>>>> >>>>>> >>>>>> >>>>>>"
                + loginResponse.getToken());
        return new ResponseEntity<UserResponse>(
                loginResponse, HttpStatus.OK);


    }

    @PostMapping("/signup")

    public User signUp(@RequestBody UserDto user) {
        return userService.createUser(user);
    }


}
