package cs489.project.carrental.controller;

import cs489.project.carrental.DTO.roleDto.CreateRoleDto;
import cs489.project.carrental.DTO.roleDto.UpdateRoleDto;
import cs489.project.carrental.model.domain.Role;
import cs489.project.carrental.service.RoleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin
public class RoleController {
    private final RoleService roleService;


    @GetMapping
    public ResponseEntity<List<Role>> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping("{id}")

    public ResponseEntity<Role> findById(@PathVariable Long id) {
        return ResponseEntity.ok(roleService.findById(id));
    }

    @PostMapping

    public ResponseEntity<Role> create(@RequestBody CreateRoleDto roleDto) {
        return new ResponseEntity<>(roleService.create(roleDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Role> update(@PathVariable Long id, @RequestBody UpdateRoleDto roleDto) {
        roleDto.setId(id);
        return ResponseEntity.ok(roleService.update(roleDto));
    }

    @DeleteMapping("{id}")

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }
}
