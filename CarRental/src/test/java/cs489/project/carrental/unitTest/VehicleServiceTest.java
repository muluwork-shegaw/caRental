package cs489.project.carrental.unitTest;

import cs489.project.carrental.DTO.VehicleDto;
import cs489.project.carrental.model.domain.Car;
import cs489.project.carrental.model.domain.Vehicle;
import cs489.project.carrental.model.helperClass.AvailabilityStatus;
import cs489.project.carrental.repository.VehicleRepository;
import cs489.project.carrental.service.Impl.VehicleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetVehicleById() {
        // Given
        Long vehicleId = 1L;
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleID(vehicleId);
        vehicle.setMake("Toyota");
        vehicle.setModel("Camry");

        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setMake("Toyota");
        vehicleDto.setModel("Camry");

        // Mock repository behavior
        when(vehicleRepository.findById(vehicleId)).thenReturn(Optional.of(vehicle));
        when(modelMapper.map(vehicle, VehicleDto.class)).thenReturn(vehicleDto);

        // When
        VehicleDto result = vehicleService.getVehicleById(vehicleId);

        // Then
        assertEquals("Toyota", result.getMake());
        assertEquals("Camry", result.getModel());
    }

    @Test
    public void testFindAvailableVehicles() {
        // Given
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleID(1L);
        vehicle1.setMake("Toyota");
        vehicle1.setModel("Corolla");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleID(2L);
        vehicle2.setMake("Honda");
        vehicle2.setModel("Accord");

        // Create available cars for the vehicles
        Car car1 = new Car();
        car1.setAvailabilityStatus(AvailabilityStatus.Available);
        car1.setVehicle(vehicle1);
        vehicle1.setCars(Collections.singletonList(car1));

        Car car2 = new Car();
        car2.setAvailabilityStatus(AvailabilityStatus.Available);
        car2.setVehicle(vehicle2);
        vehicle2.setCars(Collections.singletonList(car2));

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        when(vehicleRepository.findAll()).thenReturn(vehicles);

        // Mock the ModelMapper behavior to map Vehicle to VehicleDto
        VehicleDto vehicleDto1 = new VehicleDto();
        vehicleDto1.setMake("Toyota");
        vehicleDto1.setModel("Corolla");
        VehicleDto vehicleDto2 = new VehicleDto();
        vehicleDto2.setMake("Honda");
        vehicleDto2.setModel("Accord");
        when(modelMapper.map(vehicle1, VehicleDto.class)).thenReturn(vehicleDto1);
        when(modelMapper.map(vehicle2, VehicleDto.class)).thenReturn(vehicleDto2);

        // When
        List<VehicleDto> availableVehicles = vehicleService.findAvailableVehicles();

        // Then
        assertEquals(2, availableVehicles.size());
        assertEquals("Toyota", availableVehicles.get(0).getMake());
        assertEquals("Corolla", availableVehicles.get(0).getModel());
        assertEquals("Honda", availableVehicles.get(1).getMake());
        assertEquals("Accord", availableVehicles.get(1).getModel());
    }


    // Add more test methods for other service methods...

}
