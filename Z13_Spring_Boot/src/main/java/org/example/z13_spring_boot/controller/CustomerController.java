package org.example.z13_spring_boot.controller;

import org.example.z13_spring_boot.dto.CustomerDTO;
import org.example.z13_spring_boot.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    //property injection
    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping( "save")
    public boolean saveCustomer(@RequestBody CustomerDTO customerDTO) {
        boolean res=customerService.addCustomer(customerDTO);
        return res;
    }

    @PutMapping("update")
    public boolean updateCustomer(@RequestBody CustomerDTO customerDTO) {
        boolean res=customerService.updateCustomer(customerDTO);
        return res;
    }
    @DeleteMapping(path = "delete/{id}")
    public boolean deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return true;
    }
    @GetMapping("getAll")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
