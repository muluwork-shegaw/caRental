package cs489.project.carrental.service;

import cs489.project.carrental.DTO.roleDto.CreateRoleDto;
import cs489.project.carrental.DTO.roleDto.UpdateRoleDto;
import cs489.project.carrental.model.domain.Permission;
import cs489.project.carrental.model.domain.Role;
import jakarta.transaction.Transactional;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findById(Long id);

    Role create(CreateRoleDto roleDto);

    Role update(UpdateRoleDto roleDto);

    @Transactional
    List<Permission> getPermissionsFromId(List<Long> permissionIds);

    void delete(Long id);
}