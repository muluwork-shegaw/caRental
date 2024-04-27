package cs489.project.carrental.service;

import cs489.project.carrental.DTO.ReservationDto;
import cs489.project.carrental.model.domain.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);

    Reservation getReservationById(Long id);

    void deleteReservation(Long id);

    List<ReservationDto> browseReservationsByPickUpBranch(Long branchId);

    List<ReservationDto> browseReservationsByDropOffBranch(Long dropByBranchId);

    List<ReservationDto> browseReservations();

    void registerReservation(ReservationDto reservationDto);
}
