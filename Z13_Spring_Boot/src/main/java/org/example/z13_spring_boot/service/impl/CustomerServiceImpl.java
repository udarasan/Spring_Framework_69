package org.example.z13_spring_boot.service.impl;

import org.example.z13_spring_boot.dto.CustomerDTO;
import org.example.z13_spring_boot.entity.Customer;
import org.example.z13_spring_boot.repo.CustomerRepo;
import org.example.z13_spring_boot.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())) {
            throw new RuntimeException("Customer already exists");
        }
        customerRepo.save(modelMapper.map(customerDTO, Customer.class));
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())) {
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        }
        throw new RuntimeException("Customer does not exist");
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return modelMapper.map(customerRepo.findAll(),
                new TypeToken<List<CustomerDTO>>() {}.getType());
    }


}
