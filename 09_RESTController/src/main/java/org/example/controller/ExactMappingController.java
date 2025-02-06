package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exact")
public class ExactMappingController {
    @GetMapping(path = "test1")
    public String test1() {
        return "test 1 method invoked";
    }
    @GetMapping(path = "test2")
    public String test2() {
        return "test 2 method invoked";
    }
}
