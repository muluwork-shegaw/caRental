package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.RentalAgent;

public interface RentalAgentService {
    RentalAgent saveRentalAgent(RentalAgent rentalAgent);

    RentalAgent getRentalAgentById(Long id);

    void deleteRentalAgent(Long id);


    RentalAgent findAgentById(Long agentId);
}
