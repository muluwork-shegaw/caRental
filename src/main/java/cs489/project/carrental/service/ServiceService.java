package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.Service;

public interface ServiceService {
    Service saveService(Service service);
    Service getServiceById(Long id);
    void deleteService(Long id);
}
