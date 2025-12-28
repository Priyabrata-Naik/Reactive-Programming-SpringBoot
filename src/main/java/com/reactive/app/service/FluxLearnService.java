package com.reactive.app.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class FluxLearnService {

//    public void fluxTestingService() {
//        System.out.println("Flux testing services");
//    }

    /*Creating Flux*/
    public Flux<String> getFlux() {
        return Flux.just("Priyabrata", "Shark", "Bapu").log();
    }

    public Flux<String> fruitsFlux() {
        List<String> fruitsNames = List.of("Mango", "Apple");

        return Flux.fromIterable(fruitsNames).log();
    }

}
