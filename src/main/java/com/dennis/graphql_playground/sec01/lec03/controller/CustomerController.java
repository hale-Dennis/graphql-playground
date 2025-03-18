package com.dennis.graphql_playground.sec01.lec03.controller;


import com.dennis.graphql_playground.sec01.lec03.dto.Customer;
import com.dennis.graphql_playground.sec01.lec03.service.CustomerService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @QueryMapping("customerAll")
    public Flux<Customer> getAllCustomers() {
        return customerService.getCustomerFlux();
    }



}
