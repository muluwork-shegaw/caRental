package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    Customer getCustomerById(Long id);

    void deleteCustomer(Long id);

    List<Customer> findAll();
}
