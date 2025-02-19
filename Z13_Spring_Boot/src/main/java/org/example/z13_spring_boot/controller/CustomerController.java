package org.example.z13_spring_boot.controller;

import org.example.z13_spring_boot.dto.CustomerDTO;
import org.example.z13_spring_boot.service.impl.CustomerServiceImpl;
import org.example.z13_spring_boot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    //property injection
    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping( "save")
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO) {
        boolean res=customerService.addCustomer(customerDTO);
        if (res){
            return new ResponseUtil(201,"Customer Saved",null);
        }else {
            return new ResponseUtil(200,"Exits Customer",null);
        }

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
