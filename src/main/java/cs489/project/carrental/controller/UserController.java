package cs489.project.carrental.controller;

import cs489.project.carrental.DTO.User.BasicUserDto;
import cs489.project.carrental.DTO.User.UserDto;
import cs489.project.carrental.model.domain.User;
import cs489.project.carrental.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin
public class UserController {

    private final UserService userService;
//    private final Util util;


    @GetMapping("/current")
    public ResponseEntity<BasicUserDto> getUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/recentUsers")

    public ResponseEntity<List<User>> getRecentUsers(@RequestParam(required = false) Integer limit) {
        return ResponseEntity.ok(userService.getRecentUsers(limit == null ? Integer.valueOf(10) : limit));
    }

    @GetMapping("/{id}")

    public ResponseEntity<BasicUserDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserByID(id));
    }

    @PostMapping("/setRole/{id}")

    public ResponseEntity<User> setRole(@PathVariable Long id, @RequestBody List<Long> roleIds) {
        return ResponseEntity.ok(userService.setRole(id, roleIds));
    }

    @PutMapping("/{id}")

    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserDto user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

}
