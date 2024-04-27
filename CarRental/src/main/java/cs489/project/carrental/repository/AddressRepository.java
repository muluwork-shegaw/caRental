package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    // You can define custom database operations here if needed.
}
