package com.reactive.app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FluxLearnServiceTest {

    @Autowired
    private FluxLearnService fluxLearnService;

    @Test
    void filterExampleFlux() {
        Flux<String> filterFlux = fluxLearnService.filterExampleFlux();
        StepVerifier.create(filterFlux)
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void flatMapExample() {
        Flux<String> flatMapFlux = fluxLearnService.flatMapExample();
        StepVerifier.create(flatMapFlux)
                .expectNextCount(19)
                .verifyComplete();
    }

    @Test
    void transformExample() {
        Flux<String> transformFlux = fluxLearnService.transformExample();
        StepVerifier.create(transformFlux)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void ifExample() {
        Flux<String> stringFlux = fluxLearnService.ifExample(4);
        StepVerifier.create(stringFlux)
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void concatExample() {
        Flux<String> oneMergedFlux = fluxLearnService.concatExample();
        StepVerifier.create(oneMergedFlux)
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    void mergeWithExample() {
        Flux<String> mergeFluxExample = fluxLearnService.mergeWithExample();
        StepVerifier.create(mergeFluxExample)
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    void zipExample() {
        Flux<Tuple2<String, Integer>> tuple2FluxZipped = fluxLearnService.zipExample();
        StepVerifier.create(tuple2FluxZipped)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void zipExampleWithFunction() {
        Flux<String> zipExampleWithFunction = fluxLearnService.zipExampleWithFunction();
        StepVerifier.create(zipExampleWithFunction)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void sideEffectFlux() {
        fluxLearnService.sideEffectFlux().subscribe(System.out::println);

    }
}