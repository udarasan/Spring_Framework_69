package org.example.z13_spring_boot.service;

import org.example.z13_spring_boot.dto.CustomerDTO;

public interface CustomerService {
    boolean addCustomer(CustomerDTO customerDTO);
    boolean updateCustomer(CustomerDTO customerDTO);
}
