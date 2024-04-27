package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Feedback;
import cs489.project.carrental.model.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
