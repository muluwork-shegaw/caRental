package cs489.project.carrental.service.Impl;

import cs489.project.carrental.model.domain.Permission;
import cs489.project.carrental.repository.PermissionRepository;
import cs489.project.carrental.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public Permission savePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission getPermissionById(Long id) {
        return permissionRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }
}
