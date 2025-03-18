package com.dennis.graphql_playground.sec01.lec03.service;

import com.dennis.graphql_playground.sec01.lec03.dto.CustomerOrder;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderService {

    private final Map<String, List<CustomerOrder>> map = Map.of(
            "Naruto", List.of(
                    CustomerOrder.create(UUID.randomUUID(), "naruto-product-1"),
                    CustomerOrder.create(UUID.randomUUID(), "naruto-product-2")
            ),
            "Sasuke", List.of(
                    CustomerOrder.create(UUID.randomUUID(), "sasuke-product-1"),
                    CustomerOrder.create(UUID.randomUUID(), "sasuke-product-2")
            )
    );
}
