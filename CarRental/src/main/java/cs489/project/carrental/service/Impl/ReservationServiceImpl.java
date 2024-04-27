package cs489.project.carrental.service.Impl;

import cs489.project.carrental.DTO.ReservationDto;
import cs489.project.carrental.model.domain.Branch;
import cs489.project.carrental.model.domain.Reservation;
import cs489.project.carrental.repository.ReservationRepository;
import cs489.project.carrental.service.BranchService;
import cs489.project.carrental.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;
    private ModelMapper modelMapper;
    private BranchService branchService;

    ReservationServiceImpl(ReservationRepository reservationRepository, ModelMapper modelMapper) {
        this.reservationRepository = reservationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<ReservationDto> browseReservationsByPickUpBranch(Long pickUpBranchId) {
        Branch pickUpBranch = branchService.getBranchById(pickUpBranchId);
        List<Reservation> reservations = reservationRepository.findByPickupLocation(pickUpBranch);
        return reservations.stream().map(reservation -> modelMapper.map(reservation, ReservationDto.class)).toList();
    }

    @Override
    public List<ReservationDto> browseReservationsByDropOffBranch(Long dropByBranchId) {
        Branch dropOffBranch = branchService.getBranchById(dropByBranchId);
        List<Reservation> reservations = reservationRepository.searchAllByDropOffLocation(dropOffBranch);
        return reservations.stream().map(reservation -> modelMapper.map(reservation, ReservationDto.class)).toList();
    }

    @Override
    public List<ReservationDto> browseReservations() {
        return reservationRepository.findAll().stream().map(reservation -> modelMapper.map(reservation, ReservationDto.class)).toList();

    }

    @Override
    public void registerReservation(ReservationDto reservationDto) {

    }
}
