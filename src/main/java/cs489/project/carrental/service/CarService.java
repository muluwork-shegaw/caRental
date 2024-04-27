package cs489.project.carrental.service;

import cs489.project.carrental.DTO.CarDto;
import cs489.project.carrental.model.domain.Car;

import java.util.List;

public interface CarService {
    Car saveCar(Car car);

    Car getCarById(Long id);

    void deleteCar(Long id);

    List<Car> findAvailableCars();

    List<Car> findAllCars();

    List<CarDto> browseAvailableCarsForGivenVehicleTypeAndBranch(Long vehicleId, Long branchId);

    void registerCar(CarDto carDto, Long vehicleId, Long branchId);
}
