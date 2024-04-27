package cs489.project.carrental.service.Impl;

import cs489.project.carrental.model.domain.RentalAgent;
import cs489.project.carrental.repository.FeedbackRepository;
import cs489.project.carrental.repository.RentalAgentRepository;
import cs489.project.carrental.repository.ReservationRepository;
import cs489.project.carrental.service.CarService;
import cs489.project.carrental.service.RentalAgentService;
import org.springframework.stereotype.Service;

/**
 * This class implements the RentalAgentService interface.
 */
@Service
public class RentalAgentServiceImpl implements RentalAgentService {
    //Rental agents can easily register Car into the system with a given vehicle and branch
    //Rental agents can browse available cars for given vehicle or branch

    //Rental agents can browse cars’s feed back
    private RentalAgentRepository rentalAgentRepository;
    private CarService carService;
    private FeedbackRepository feedbackRepository;
    private ReservationRepository reservationRepository;

    RentalAgentServiceImpl(RentalAgentRepository rentalAgentRepository) {
        this.rentalAgentRepository = rentalAgentRepository;

    }


    @Override
    public RentalAgent saveRentalAgent(RentalAgent rentalAgent) {
        return rentalAgentRepository.save(rentalAgent);
    }

    @Override
    public RentalAgent getRentalAgentById(Long id) {
        return rentalAgentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRentalAgent(Long id) {
        rentalAgentRepository.deleteById(id);
    }

    @Override
    public RentalAgent findAgentById(Long agentId) {
        return rentalAgentRepository.findById(agentId).orElse(null);
    }


}
