package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Additional queries related to the customer can be defined here.
}
