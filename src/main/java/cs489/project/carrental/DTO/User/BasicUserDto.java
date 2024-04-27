package cs489.project.carrental.DTO.User;

import cs489.project.carrental.model.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class BasicUserDto {
    private Long id;
    private String fName;
    private String lName;
    private String email;
    private String phoneNumber;
    private String password;
    private List<Role> roles;


}
