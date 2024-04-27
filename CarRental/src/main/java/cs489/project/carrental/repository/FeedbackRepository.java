package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // Define methods for handling feedback here.
}
