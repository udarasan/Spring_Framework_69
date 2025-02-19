package org.example.z13_spring_boot.service.impl;

import org.example.z13_spring_boot.dto.CustomerDTO;
import org.example.z13_spring_boot.entity.Customer;
import org.example.z13_spring_boot.repo.CustomerRepo;
import org.example.z13_spring_boot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        if (customerRepo.existsById(customerDTO.getId())) {
            customerRepo.save(new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress()));
            return true;
        }
        return false;
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer>customerList=customerRepo.findAll();
        List<CustomerDTO> customerDTOList=new ArrayList<>();
        for (Customer customer:customerList) {
            customerDTOList.add(
                    new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));
        }
        return customerDTOList;
    }


}
