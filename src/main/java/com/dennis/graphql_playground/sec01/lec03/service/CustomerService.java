package com.dennis.graphql_playground.sec01.lec03.service;


import com.dennis.graphql_playground.sec01.lec03.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CustomerService {

    private final Flux<Customer> customerFlux =  Flux.just(
            Customer.create(1, "Naruto", 23, "Dresrosa"),
            Customer.create(2, "Sasuke", 25, "Wano"),
            Customer.create(3, "Sanji", 24, "Gemma 66"),
            Customer.create(4, "Jimbe", 55, "Fishman Island")
    );

    public Flux<Customer> getCustomerFlux() {
        return customerFlux;
    }
}
