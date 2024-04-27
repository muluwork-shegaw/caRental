package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Branch;
import cs489.project.carrental.model.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> searchAllByDropOffLocation(Branch dropOffLocation);

    List<Reservation> findByPickupLocation(Branch pickUpLocation);
    // Here, you can define custom methods to handle reservation-specific queries.
}
