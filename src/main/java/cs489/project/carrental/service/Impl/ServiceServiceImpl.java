package cs489.project.carrental.service.Impl;

import cs489.project.carrental.model.domain.Service;
import cs489.project.carrental.repository.ServiceRepository;
import cs489.project.carrental.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Service saveService(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
