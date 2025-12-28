package com.reactive.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

import java.time.Duration;

@SpringBootTest
class ReactiveProjectApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void workingWithMono() throws InterruptedException {
        System.out.println("Testing");

//        Mono<String> errorMono = Mono.error(new RuntimeException("Error !!!"));
//
//        Mono<String> m1 = Mono
//                .just("Learn code with Durgesh")
//                .log()
//                .then(errorMono);
//
//
////        m1.subscribe(data -> {
////            System.out.println("Data is " + data);
////        });
//
//        m1.subscribe(System.out::println);
//        errorMono.subscribe(System.out::println);

        Mono<String> m1 = Mono.just("Learn code with Durgesh").delayElement(Duration.ofSeconds(2));
        Mono<String> m2 = Mono.just("Subscribe to this channel");
        Mono<Integer> m3 = Mono.just(23583);

//        System.out.println(Thread.currentThread().getName());
//        Flux<String> stringFlux = m1.concatWith(m2)
//                .log()
//                .delayElements(Duration.ofMillis(2000));
//        stringFlux.subscribe((data) -> {
//            System.out.println(Thread.currentThread().getName());
//            System.out.println(data);
//        });
//
//        Thread.sleep(4000);
//        System.out.println("Thread terminated");

        m1.subscribe((data) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(data);
        });

        Thread.sleep(3000);

//        Mono<String> upperCaseMono = m1.map(item -> item.toUpperCase());
//
//        Mono<String[]> resultFlatExample = m1.flatMap(valueM1 -> Mono.just(valueM1.split(" ")));
//
//        upperCaseMono.subscribe(System.out::println);
//        resultFlatExample.subscribe(items -> {
//            for (String item : items) {
//                System.out.println(item);
//            }
//        });
//
//        Flux<String> stringFlux = m1.flatMapMany(valueM1 -> Flux.just(valueM1.split(" ")).log());
//
//        stringFlux.subscribe(data -> {
//            System.out.println(data.toUpperCase());
//        });

//        Mono<Tuple3<String, String, Integer>> zipped = Mono.zip(m1, m2, m3);
//
//        zipped.subscribe(data -> {
//            System.out.println(data.getT1());
//            System.out.println(data.getT2());
//            System.out.println(data.getT3());
//        });
//
//        System.out.println("Next Line");
//        System.out.println();
//
//        Mono<Tuple2<String, String>> monoWithZip = m1.zipWith(m2);
//
//        monoWithZip.subscribe(data -> {
//            System.out.println(data.getT1());
//            System.out.println(data.getT2());
//        });

    }

}
