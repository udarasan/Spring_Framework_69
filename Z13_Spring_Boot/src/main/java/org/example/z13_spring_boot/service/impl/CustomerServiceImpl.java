package org.example.z13_spring_boot.service.impl;

import org.example.z13_spring_boot.dto.CustomerDTO;
import org.example.z13_spring_boot.entity.Customer;
import org.example.z13_spring_boot.repo.CustomerRepo;
import org.example.z13_spring_boot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())) {
            return false;
        }
        Customer customer=new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress());
        customerRepo.save(customer);
        return true;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        return false;
    }
}
