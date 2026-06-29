package com.practice.shoping.service;

import com.practice.shoping.entity.CustomerEntity;
import com.practice.shoping.entity.OrdersEntity;
import com.practice.shoping.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public String save(CustomerEntity customer) {
        List<OrdersEntity> orders = customer.getOrders();
        if(orders!=null) {
            for(OrdersEntity order: orders) {
                order.setCustomer(customer);
            }
        }
        repository.save(customer);
        return "Created.....!";
    }

    public CustomerEntity find(int id) {
        Optional<CustomerEntity> customers = repository.findById(id);
        if(customers.isPresent()) {
            return customers.get();
        } else {
            return null;
        }
    }

    public String delete(int id) {
        Optional<CustomerEntity> customer = repository.findById(id);
        if(customer.isPresent()) {
            repository.deleteById(id);
            return "successfully deleted.....!";
        } else {
            return "There is no record...";
        }
    }
}
