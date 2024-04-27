package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Feedback;
import cs489.project.carrental.model.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // Define methods to fetch vehicle data as needed.

//    List<Vehicle> findAll();
}
