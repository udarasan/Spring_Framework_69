package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String sayHello() {
        return "get mapping invoked";
    }
    @PostMapping
    public String sayHelloPost() {
        return "post mapping invoked";
    }
    @DeleteMapping
    public String sayHelloDelete() {
        return "delete mapping invoked";
    }
    @PutMapping
    public String sayHelloPut() {
        return "put mapping invoked";
    }
    @PatchMapping
    public String sayHelloPatch() {
        return "patch mapping invoked";
    }
}
