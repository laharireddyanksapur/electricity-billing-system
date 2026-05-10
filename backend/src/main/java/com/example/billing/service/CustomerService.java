package com.example.billing.service;

import com.example.billing.model.Customer;
import com.example.billing.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer updateCustomer(Long id, Customer customer) {

        Customer existingCustomer = repository.findById(id).orElse(null);

        if (existingCustomer != null) {

            existingCustomer.setName(customer.getName());
            existingCustomer.setMeterNumber(customer.getMeterNumber());
            existingCustomer.setUnitsConsumed(customer.getUnitsConsumed());

            return repository.save(existingCustomer);
        }

        return null;
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}