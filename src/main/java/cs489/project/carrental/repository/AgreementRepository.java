package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
    // Methods to manage agreements can be defined here.
}
