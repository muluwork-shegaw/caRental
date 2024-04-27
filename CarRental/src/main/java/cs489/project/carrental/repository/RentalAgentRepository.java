package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.RentalAgent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalAgentRepository extends JpaRepository<RentalAgent, Long> {
    // Additional methods for RentalAgent operations can be added here.
}
