package cs489.project.carrental.service.Impl;

import cs489.project.carrental.DTO.roleDto.CreateRoleDto;
import cs489.project.carrental.DTO.roleDto.UpdateRoleDto;
import cs489.project.carrental.model.domain.Permission;
import cs489.project.carrental.model.domain.Role;
import cs489.project.carrental.repository.PermissionRepository;
import cs489.project.carrental.repository.RoleRepository;
import cs489.project.carrental.service.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepo;
    private final PermissionRepository permissionRepo;

    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public Role findById(Long id) {
        var role = roleRepo.findById(id);

        if (role.isPresent())
            return role.get();

        throw new NoSuchElementException("Role Not Found.");
    }

    @Override
    @Transactional
    public Role create(CreateRoleDto roleDto) {
        Role role = new Role();
        role.setName(roleDto.getName());

        final List<Permission> permissions = getPermissionsFromId(roleDto.getPermissionIds());
        role.setPermissions(permissions);

        return roleRepo.save(role);
    }


    @Override
    public Role update(UpdateRoleDto roleDto) {
        var role = findById(roleDto.getId());

        System.out.println(role.getId());

        role.setName(roleDto.getName());
        List<Permission> permissions = getPermissionsFromId(roleDto.getPermissionIds());
        role.setPermissions(permissions);
        return roleRepo.save(role);
    }

    @Override
    public List<Permission> getPermissionsFromId(List<Long> permissionIds) {
        List<Permission> permissions = new ArrayList<>();

        permissionIds
                .parallelStream()
                .forEach(permissionId -> {
                    var permission = permissionRepo.findById(permissionId);
                    if (permission.isPresent())
                        permissions.add(permission.get());
                    else
                        throw new NoSuchElementException("Permission Not Found.");
                });

        return permissions;
    }

    @Override
    public void delete(Long id) {
        Role role = findById(id);
        roleRepo.delete(role);

    }
}
