package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Agreement;
import cs489.project.carrental.model.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge, Long> {
    // Methods to manage agreements can be defined here.
}
