package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String> {
    // Methods to manage card details can be added here.
}

