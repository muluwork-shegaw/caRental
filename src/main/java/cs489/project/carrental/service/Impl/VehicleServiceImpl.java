package cs489.project.carrental.service.Impl;

import cs489.project.carrental.DTO.VehicleDto;
import cs489.project.carrental.model.domain.Branch;
import cs489.project.carrental.model.domain.Vehicle;
import cs489.project.carrental.model.helperClass.AvailabilityStatus;
import cs489.project.carrental.repository.VehicleRepository;
import cs489.project.carrental.service.VehicleService;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
        Vehicle vehicleSaved = vehicleRepository.save(vehicle);
        VehicleDto vehicleDtoRes = modelMapper.map(vehicleSaved, VehicleDto.class);
        return vehicleDtoRes;
    }

    @Override
    public VehicleDto getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        VehicleDto vehicleDto = modelMapper.map(vehicle, VehicleDto.class);
        return vehicleDto;
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleDto> vehicleDtos = vehicles.stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
        return vehicleDtos;
    }

    @Override
    public void saveAllVehicles(List<VehicleDto> vehicleDtos) {
        List<Vehicle> vehicleList = vehicleDtos.stream()
                .map(vehicleDto -> modelMapper.map(vehicleDto, Vehicle.class))
                .collect(Collectors.toList());
        vehicleRepository.saveAll(vehicleList);
    }

    @Override
    public List<VehicleDto> findAvailableVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleDto> vehicleDtos = vehicles.stream()
                .filter(vehicle -> vehicle.getCars().stream().allMatch(car -> car.getAvailabilityStatus().equals(AvailabilityStatus.Available)))
                .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
        return vehicleDtos;

    }

    @Override
    public List<VehicleDto> findAvailableVehiclesByBranch(Branch branch) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleDto> vehicleDtos = vehicles.stream()
                .filter(vehicle -> vehicle.getCars().stream().allMatch(car -> car.getAvailabilityStatus().equals(AvailabilityStatus.Available)))
                .filter(vehicle -> vehicle.getCars().stream().anyMatch(car -> car.getBranch().equals(branch)))
                .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
        return vehicleDtos;

    }


}
