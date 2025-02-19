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
        customerService.addCustomer(customerDTO);
        return new ResponseUtil(201,"Customer Saved",null);
    }

    @PutMapping("update")
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
        return new ResponseUtil(200,"Customer Updated",null);

    }
    @DeleteMapping(path = "delete/{id}")
    public ResponseUtil deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return new ResponseUtil(200,"Customer Deleted",null);
    }
    @GetMapping("getAll")
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil(
                200,
                "Customer List",
                customerService.getAllCustomers());
    }

}
