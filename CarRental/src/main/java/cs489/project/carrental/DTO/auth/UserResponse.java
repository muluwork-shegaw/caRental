package cs489.project.carrental.DTO.auth;

import cs489.project.carrental.DTO.User.BasicUserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String token;
    private String message;
    private BasicUserDto user;
}
