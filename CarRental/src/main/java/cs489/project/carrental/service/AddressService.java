package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.Address;

public interface AddressService {
    Address saveAddress(Address address);
    Address getAddressById(Long id);
    void deleteAddress(Long id);
}

