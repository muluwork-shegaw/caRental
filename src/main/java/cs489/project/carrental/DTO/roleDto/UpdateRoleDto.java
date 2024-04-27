package cs489.project.carrental.DTO.roleDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateRoleDto {
    @JsonIgnore
    private Long id;

    private String name;

    private List<Long> permissionIds;
}
