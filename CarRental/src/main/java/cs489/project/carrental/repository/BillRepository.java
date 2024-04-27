package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
    // Custom methods for Bill operations can be added here.
}
