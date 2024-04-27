package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getByName(String name);
}
