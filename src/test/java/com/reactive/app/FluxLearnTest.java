package com.reactive.app;

import com.reactive.app.service.FluxLearnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class FluxLearnTest {

    @Autowired
    private FluxLearnService fluxLearnService;

//    @Test
//    void testing() {
//        fluxLearnService.fluxTestingService();
//    }

    @Test
    public void simpleFluxTest() {
//        fluxLearnService.getFlux().subscribe(data -> {
//            System.out.println(data);
//            System.out.println("Done with flux data");
//        });

        fluxLearnService.fruitsFlux().subscribe(System.out::println);
    }

    @Test
    public void mapTest() {
//        fluxLearnService.mapExampleFlux().subscribe(data -> {
//            System.out.println(data);
//            System.out.println("One data processed");
//        });

        Flux<String> capFlux = fluxLearnService.mapExampleFlux();

        StepVerifier.create(capFlux)
//                .expectNextCount(3)
                .expectNext("Priyabrata".toUpperCase(), "Shark".toUpperCase(), "Bapu".toUpperCase())
                .verifyComplete();

    }


}
