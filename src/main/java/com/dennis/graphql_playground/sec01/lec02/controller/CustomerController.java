package com.dennis.graphql_playground.sec01.lec02.controller;


import com.dennis.graphql_playground.sec01.lec02.dto.AgeRangeFilter;
import com.dennis.graphql_playground.sec01.lec02.dto.Customer;
import com.dennis.graphql_playground.sec01.lec02.service.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @QueryMapping("customerById")
    public Mono<Customer> getCustomerById(@Argument Integer id){
        return customerService.getCustomerById(id);
    }


    @QueryMapping("customerNameContains")
    public Flux<Customer> getCustomerByName(@Argument String name) {
        return  customerService.getCustomerByName(name);
    }


    @QueryMapping("customerByAgeRange")
    public Flux<Customer> getCustomerByAge(@Argument AgeRangeFilter filter){
        return this.customerService.withingAgeRange(filter);
    }

}
