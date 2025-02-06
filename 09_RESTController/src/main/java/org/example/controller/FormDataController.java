package org.example.controller;

import org.example.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("form")
public class FormDataController {
    //id-1
    //name-ewe
    //address-wewe

    @PostMapping
    public String test1(@RequestParam("id") String id,@RequestParam("name")String name) {
        return id + " " + name;
    }
    @PostMapping(path = "test2")
    public String test2(@ModelAttribute CustomerDTO customerDTO) {
        return customerDTO.toString();
    }
}

