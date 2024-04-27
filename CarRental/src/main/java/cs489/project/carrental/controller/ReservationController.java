package cs489.project.carrental.controller;

import cs489.project.carrental.DTO.ReservationDto;
import cs489.project.carrental.model.domain.Reservation;
import cs489.project.carrental.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ModelMapper modelMapper;
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService, ModelMapper modelMapper) {
        this.reservationService = reservationService;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/register")
    public ResponseEntity<ReservationDto> registerReservation(@RequestBody ReservationDto reservationDto) {
        Reservation reservation = reservationService.saveReservation(modelMapper.map(reservationDto, Reservation.class));
        return new ResponseEntity<>(modelMapper.map(reservation, ReservationDto.class), HttpStatus.CREATED);
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<ReservationDto> getReservationById(@PathVariable Long reservationId) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        ReservationDto reservationDto = modelMapper.map(reservation, ReservationDto.class);
        if (reservationDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reservationDto, HttpStatus.OK);
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity<ReservationDto> updateReservation(@PathVariable Long reservationId, @RequestBody ReservationDto reservationDto) {
        Reservation existingReservation = reservationService.getReservationById(reservationId);
        if (existingReservation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ReservationDto existingReservationDto = modelMapper.map(existingReservation, ReservationDto.class);

        return new ResponseEntity<>(existingReservationDto, HttpStatus.OK);

    }

}
