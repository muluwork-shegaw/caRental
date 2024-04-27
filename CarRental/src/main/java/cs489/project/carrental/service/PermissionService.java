package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.Permission;

public interface PermissionService {
    Permission savePermission(Permission permission);
    Permission getPermissionById(Long id);
    void deletePermission(Long id);
}
