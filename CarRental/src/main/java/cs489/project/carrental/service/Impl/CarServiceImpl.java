package cs489.project.carrental.service.Impl;

import cs489.project.carrental.DTO.CarDto;
import cs489.project.carrental.DTO.VehicleDto;
import cs489.project.carrental.model.domain.Branch;
import cs489.project.carrental.model.domain.Car;
import cs489.project.carrental.model.domain.Vehicle;
import cs489.project.carrental.model.helperClass.AvailabilityStatus;
import cs489.project.carrental.repository.CarRepository;
import cs489.project.carrental.repository.VehicleRepository;
import cs489.project.carrental.service.CarService;
import cs489.project.carrental.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private VehicleRepository vehicleRepository;
    private BranchServiceImpl branchService;
    private ModelMapper modelMapper;
    private VehicleService vehicleService;
    private CarService carService;

    CarServiceImpl(CarRepository carRepository, VehicleRepository vehicleRepository, BranchServiceImpl branchService, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.vehicleRepository = vehicleRepository;
        this.branchService = branchService;
        this.modelMapper = modelMapper;
        this.vehicleService = vehicleService;
        this.carService = carService;
    }


    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public List<Car> findAvailableCars() {
        return carRepository.findByAvailabilityStatus(AvailabilityStatus.Available);
    }

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }


    public List<CarDto> browseAvailableCarsForGivenVehicleTypeAndBranch(Long vehicleId, Long branchId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        Branch branch = branchService.getBranchById(branchId);
        if (vehicle == null || branch == null) {
            throw new NoSuchElementException("Vehicle or branch not found");
        }
        List<Car> cars = carRepository.searchAllByVehicleAndBranchAndAvailabilityStatus(vehicle, branch, AvailabilityStatus.Available);
        return cars.stream().map(car -> modelMapper.map(car, CarDto.class)).toList();
    }

    @Override
    public void registerCar(CarDto carDto, Long vehicleId, Long branchId) {
        VehicleDto vehicle = vehicleService.getVehicleById(vehicleId);
        Branch branch = branchService.getBranchById(branchId);
        if (vehicle == null || branch == null) {
            throw new IllegalArgumentException("Vehicle or branch not found");
        }
        Car car = modelMapper.map(carDto, Car.class);
        car.setBranch(branch);
        car.setVehicle(modelMapper.map(vehicle, Vehicle.class));
        car.setAvailabilityStatus(AvailabilityStatus.Available);
        carService.saveCar(car);
    }

}
