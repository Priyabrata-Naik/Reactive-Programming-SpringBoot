package com.reactive.app.service;

import com.reactive.app.entity.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

    Mono<Book> create(Book book);

    Flux<Book> getAll();

    Mono<Book> getABookById(Long bookId);

    Mono<Book> updateBookById(Long bookId, Book book);

    Mono<Void> deleteABookById(Long bookId);

    Flux<Book> searchBooks(String query);

}
