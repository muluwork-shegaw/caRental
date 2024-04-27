package cs489.project.carrental.repository;

import cs489.project.carrental.model.domain.Branch;
import cs489.project.carrental.model.domain.Car;
import cs489.project.carrental.model.domain.Vehicle;
import cs489.project.carrental.model.helperClass.AvailabilityStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByAvailabilityStatus(AvailabilityStatus status);

    //find all cars by vehicle id
    List<Car> findByVehicle(Vehicle vehicle);

    //find all cars by vehicle id and branch id which are available
    List<Car> searchAllByVehicleAndBranchAndAvailabilityStatus(Vehicle vehicle, Branch branch, AvailabilityStatus availabilityStatus);


    // Custom methods to fetch car-specific data can be added here.
}
