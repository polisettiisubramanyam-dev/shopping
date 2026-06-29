package com.practice.shoping.controller;


import com.practice.shoping.entity.CustomerEntity;
import com.practice.shoping.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("/save")
    public ResponseEntity<String> create(@RequestBody CustomerEntity customer) {
        String status = service.save(customer);
        return ResponseEntity.ok().body(status);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<CustomerEntity> find(@PathVariable int id) {
        CustomerEntity customers = service.find(id);
        return ResponseEntity.ok().body(customers);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        String status = service.delete(id);
        return ResponseEntity.ok().body(status);
    }
}
