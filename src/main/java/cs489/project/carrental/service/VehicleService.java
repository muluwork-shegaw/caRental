package cs489.project.carrental.service;

import cs489.project.carrental.DTO.VehicleDto;
import cs489.project.carrental.model.domain.Branch;

import java.util.List;

public interface VehicleService {
    VehicleDto saveVehicle(VehicleDto vehicleDto);

    VehicleDto getVehicleById(Long id);

    void deleteVehicle(Long id);

    List<VehicleDto> getAllVehicles();

    void saveAllVehicles(List<VehicleDto> vehicles);

    List<VehicleDto> findAvailableVehicles();

    public List<VehicleDto> findAvailableVehiclesByBranch(Branch branch);
}
