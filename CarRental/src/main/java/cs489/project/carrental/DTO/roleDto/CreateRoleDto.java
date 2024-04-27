package cs489.project.carrental.DTO.roleDto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateRoleDto {
    private String name;
    private List<Long> permissionIds;
}

