package com.reactive.app.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

@Service
public class FluxLearnService {

//    public void fluxTestingService() {
//        System.out.println("Flux testing services");
//    }

    /*Creating Flux*/
    public Flux<String> getFlux() {
        return Flux.just("Priyabrata", "Shark", "Bapu");
    }

    public Flux<String> fruitsFlux() {
        List<String> fruitsNames = List.of("Mango", "Apple");

        return Flux.fromIterable(fruitsNames);
    }

    public Flux<Void> getBlankFlux() {
        return Flux.empty();
    }

//    Note: map operator

    public Flux<String> mapExampleFlux() {
        return getFlux().map(String::toUpperCase).log();
    }

    //    Filter example flux
    public Flux<String> filterExampleFlux() {
        return getFlux().filter(name -> name.length() >= 5).log();
    }

    public Flux<String> flatMapExample() {
//        return getFlux().flatMap(name -> Flux.just(name.split(""))).log();
        return getFlux().flatMap(name -> Flux.just(name.split(""))).delayElements(Duration.ofSeconds(2)).log();
    }

    //    transform example
    public Flux<String> transformExample() {
        Function<Flux<String>, Flux<String>> funInterface = (name) -> name.map(String::toUpperCase);
        return getFlux().transform(funInterface).log();
    }

    // defaultIfEmpty
//    switchIfEmpty
    public Flux<String> ifExample(int length) {
        return getFlux()
                .filter(name -> name.length() > length)
//                .defaultIfEmpty("No name")
                .switchIfEmpty(fruitsFlux())
                .log();
    }

    //    concat(static) or concatWith(instance)
    public Flux<String> concatExample() {
//        return Flux.concat(getFlux(), fruitsFlux()).log();
        return getFlux().concatWith(fruitsFlux()).log();
    }

    //    merge & mergeWith
    public Flux<String> mergeWithExample() {
        return Flux.merge(getFlux(), fruitsFlux()).log();
    }

    //    zip & zipWith Example
    public Flux<Tuple2<String, Integer>> zipExample() {
        return Flux.zip(getFlux(), Flux.just(123, 5, 8)).log();
    }

    public Flux<String> zipExampleWithFunction() {
        return Flux.zip(getFlux(), Flux.just(123, 5, 8), (first, second) -> {
            return first + " : " + second;
        }).log();
    }

    public Flux<String> sideEffectFlux() {
        return getFlux().doOnNext(data -> {
                    System.out.println(data + " on Next");
                })
                .doOnSubscribe(data -> {
                    System.out.println(data + " on subscribe");
                })
                .doOnEach(data -> {
                    System.out.println(data + " each");
                })
                .doOnComplete(() -> {
                    System.out.println("Completed");
                })
                .log();
    }


}
