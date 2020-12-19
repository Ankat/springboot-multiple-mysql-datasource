package com.ankat.controller;

import com.ankat.model.db1.User;
import com.ankat.model.db3.Customer;
import com.ankat.repository.db1.UserRepository;
import com.ankat.repository.db3.CustomerRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log
@RestController(value = "customerController")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/getCustomers")
    public String getUsers() {
        List<Customer> customerList = customerRepository.findAll();
        return Optional.ofNullable(customerList).map(cl -> cl.isEmpty() ? "No User Found" : cl.toString()).orElse("No Customer Found");
    }

    @GetMapping(value = "/getCustomerById/{custId}")
    public Object getUserById(@PathVariable Long custId) {
        log.info(String.valueOf(custId));
        Optional<Customer> customer = customerRepository.findById(custId);
        return customer.orElseThrow(IllegalArgumentException::new);
        //return customer.orElseGet(Customer::new);
    }

    @GetMapping(value = "/getCustomerById")
    public Object getUserById(@RequestParam Optional<Long> custId) {
        log.info(String.valueOf(custId));
        return custId.map(cId -> {
            Optional<Customer> customer = customerRepository.findById(cId);
            return customer.map(c -> customer.get().toString()).orElse("No Customer Found");
        }).orElse("User Id Not Provided");
    }

    @PostMapping(value = "/addCustomer")
    public String addUser(@RequestBody Optional<Customer> customer) {
        log.info(customer.toString());
        return Optional.ofNullable(customerRepository.save(customer.get())).map(u -> u.toString()).orElse("No Customer Found");
    }

}
