package cs489.project.carrental.controller;

import cs489.project.carrental.DTO.VehicleDto;
import cs489.project.carrental.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    ModelMapper modelMapper;
    private VehicleService vehicleService;

    VehicleController(VehicleService vehicleService, ModelMapper modelMapper) {
        this.vehicleService = vehicleService;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/register")
    public ResponseEntity<VehicleDto> registerVehicle(@RequestBody VehicleDto vehicleDto) {
        VehicleDto vehicle = vehicleService.saveVehicle(vehicleDto);
        return new ResponseEntity<>(vehicle, HttpStatus.CREATED);
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable Long vehicleId) {
        VehicleDto vehicle = vehicleService.getVehicleById(vehicleId);
        if (vehicle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable Long vehicleId, @RequestBody VehicleDto vehicleDto) {
        VehicleDto existingVehicle = vehicleService.getVehicleById(vehicleId);
        if (existingVehicle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        existingVehicle = vehicleService.saveVehicle(existingVehicle);
        return new ResponseEntity<>(existingVehicle, HttpStatus.OK);
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long vehicleId) {
        VehicleDto vehicle = vehicleService.getVehicleById(vehicleId);
        if (vehicle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        vehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        List<VehicleDto> vehicles = vehicleService.getAllVehicles();

        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{vehicleId}/feedback")
    public ResponseEntity<List<String>> getVehicleFeedback(@PathVariable Long vehicleId) {
        //TODO

//        List<String> feedbacks = vehicleService.getVehicleFeedback(vehicleId);
//        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // Additional methods for browsing vehicle inventory and feedback
    // ...

}
