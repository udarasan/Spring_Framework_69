package org.example.z13_spring_boot.service;

import org.example.z13_spring_boot.dto.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public boolean addCustomer(CustomerDTO customerDTO) {
        System.out.println("Service Method"+customerDTO.getAddress());
        return true;
    }
}
