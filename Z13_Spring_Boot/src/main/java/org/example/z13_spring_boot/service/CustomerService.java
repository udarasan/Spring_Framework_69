package org.example.z13_spring_boot.service;

import org.example.z13_spring_boot.dto.CustomerDTO;
import org.example.z13_spring_boot.entity.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(int id);
    List<CustomerDTO> getAllCustomers();
}
