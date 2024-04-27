package cs489.project.carrental.controller;

import cs489.project.carrental.DTO.CarDto;
import cs489.project.carrental.DTO.CardDto;
import cs489.project.carrental.model.domain.Car;
import cs489.project.carrental.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarController {
    private CarService carService;
    private ModelMapper modelMapper;

    public CarController(CarService carService) {
        this.carService = carService;
        this.modelMapper = new ModelMapper();
    }

    @GetMapping("/available")
    public ResponseEntity<List<CarDto>> getAvailableCars() {
        List<Car> availableCars = carService.findAvailableCars();
        List<CarDto> availableCarsDto = availableCars.stream()
                .map(car -> modelMapper.map(car, CarDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(availableCarsDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CardDto>> getAllCars() {
        List<Car> allCars = carService.findAllCars();
        List<CardDto> allCarsDto = allCars.stream()
                .map(car -> modelMapper.map(car, CardDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(allCarsDto);
    }

    @PostMapping("/add")
    public ResponseEntity<CarDto> addCar(CarDto carDto) {
        Car savedCar = carService.saveCar(modelMapper.map(carDto, Car.class));
        return ResponseEntity.ok(modelMapper.map(savedCar, CarDto.class));
    }


    @PutMapping("/update")
    public ResponseEntity<CarDto> updateCar(CarDto carDto) {
        Car updatedCar = carService.saveCar(modelMapper.map(carDto, Car.class));
        return ResponseEntity.ok(modelMapper.map(updatedCar, CarDto.class));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }

    // Additional endpoints for CRUD operations

}

