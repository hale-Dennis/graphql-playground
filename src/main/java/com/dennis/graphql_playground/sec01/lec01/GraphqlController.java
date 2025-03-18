package com.dennis.graphql_playground.sec01.lec01;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class GraphqlController {

    @QueryMapping
    public Mono<String> sayHello(){
        return Mono.just("Hello World");
    }

    @QueryMapping("sayHelloTo")
    public Mono<String> greetSomeone(@Argument("name") String value){
        return Mono.just("Hello " + value);
    }

    @QueryMapping
    public Mono<Integer> random(){
        return Mono.just(ThreadLocalRandom.current().nextInt(0,100));
    }
}
