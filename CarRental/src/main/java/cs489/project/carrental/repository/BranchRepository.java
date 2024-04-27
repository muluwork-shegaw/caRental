package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    // Custom methods for Branch can be added.
}
