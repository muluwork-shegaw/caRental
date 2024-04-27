package cs489.project.carrental.controller;

import cs489.project.carrental.DTO.CarDto;
import cs489.project.carrental.DTO.FeedbackDto;
import cs489.project.carrental.DTO.ReservationDto;
import cs489.project.carrental.DTO.VehicleDto;
import cs489.project.carrental.DTO.request.AvailableCarReqDto;
import cs489.project.carrental.DTO.request.DurationReqDto;
import cs489.project.carrental.service.CarService;
import cs489.project.carrental.service.FeedbackService;
import cs489.project.carrental.service.ReservationService;
import cs489.project.carrental.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rentalAgent")
public class RentalAgentController {
    // Controller methods for handling rental agent operations can be added here.
    // For example, methods for adding, updating, and deleting rental agents can be added here.
    // Methods for fetching rental agents can also be added here.
    //Rental agents can easily register new Vehicle into the system  ,
    //Rental agents can easily register Car into the system with a given vehicle and branch
    //Rental agents can browse available cars for given vehicle or branch
    //Rental agents can browse available cars for given vehicle or branch

    private final VehicleService vehicleService;
    private final CarService carService;

    private final ReservationService reservationService;
    private final FeedbackService feedbackService;


    public RentalAgentController(VehicleService vehicleService, CarService carService,
                                 ReservationService reservationService, FeedbackService feedbackService) {
        this.vehicleService = vehicleService;
        this.carService = carService;

        this.reservationService = reservationService;
        this.feedbackService = feedbackService;
    }

    @GetMapping("/registerVehicle")
    public ResponseEntity<VehicleDto> registerVehicle(VehicleDto vehicleDto) {
        VehicleDto vehicleDtoRes = vehicleService.saveVehicle(vehicleDto);
        return ResponseEntity.ok(vehicleDtoRes);
    }

    @GetMapping("/registerCar")
    public ResponseEntity<CarDto> registerCar(CarDto carDto, Long vehicleId, Long branchId) {
        carService.registerCar(carDto, vehicleId, branchId);
        return ResponseEntity.ok(carDto);
    }

    @GetMapping("/browseAvailableCars")
    public ResponseEntity<List<CarDto>> browseAvailableCars(@RequestBody AvailableCarReqDto availableCarReqDto) {
        Long vehicleId = availableCarReqDto.getVehicleId();
        Long branchId = availableCarReqDto.getBranchId();
        List<CarDto> availableCars = carService.browseAvailableCarsForGivenVehicleTypeAndBranch(vehicleId, branchId);
        return ResponseEntity.ok(availableCars);
    }

    @GetMapping("/browseFeedbacks/")
    public ResponseEntity<List<FeedbackDto>> browseFeedbacks() {
        List<FeedbackDto> allFeedBacks = feedbackService.browseFeedbacks();
        return ResponseEntity.ok(allFeedBacks);
    }

    @GetMapping("/browseFeedBacksByPeriod/")
    public ResponseEntity<List<FeedbackDto>> browseFeedBacksByPeriod(@RequestBody DurationReqDto durationReqDto) {

        List<FeedbackDto> allFeedBacks = feedbackService.browseFeedBacksByPeriod(durationReqDto.getStartDate(), durationReqDto.getEndDate());
        return ResponseEntity.ok(allFeedBacks);
    }

    @GetMapping("/browseReservationsByPickUpBranch")
    public ResponseEntity<List<ReservationDto>> browseReservationsByPickUpBranch(Long branchId) {
        List<ReservationDto> reservations = reservationService.browseReservationsByPickUpBranch(branchId);
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/browseReservationsByDropOffBranch")
    public ResponseEntity<List<ReservationDto>> browseReservationsByDropOffBranch(Long branchId) {
        List<ReservationDto> reservations = reservationService.browseReservationsByDropOffBranch(branchId);
        return ResponseEntity.ok(reservations);

    }

}
