package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    // Define methods to fetch service data as needed.
}
