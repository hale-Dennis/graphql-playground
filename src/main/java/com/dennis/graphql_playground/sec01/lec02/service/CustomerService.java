package com.dennis.graphql_playground.sec01.lec02.service;


import com.dennis.graphql_playground.sec01.lec02.dto.AgeRangeFilter;
import com.dennis.graphql_playground.sec01.lec02.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    private final Flux<Customer> customerFlux =  Flux.just(
            Customer.create(1, "Nami", 23, "Dresrosa"),
            Customer.create(2, "Zoro", 25, "Wano"),
            Customer.create(3, "Sanji", 24, "Gemma 66"),
            Customer.create(4, "Jimbe", 55, "Fishman Island")
    );

    public Flux<Customer> getCustomerFlux() {
        return customerFlux;
    }

    public Mono<Customer> getCustomerById(Integer id) {
        return customerFlux.filter(customer -> customer.getId().equals(id))
                .next();
    }

    public Flux<Customer> getCustomerByName(String name) {
        return customerFlux.filter(customer -> customer.getName().contains(name));
    }

    public Flux<Customer> withingAgeRange(AgeRangeFilter filter) {
        return customerFlux
                .filter( customer -> customer.getAge() >= filter.getMinAge() && customer.getAge() <= filter.getMaxAge());
    }
}
