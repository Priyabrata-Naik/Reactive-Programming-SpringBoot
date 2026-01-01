package com.reactive.app.service.impl;

import com.reactive.app.entity.Book;
import com.reactive.app.repository.BookRepository;
import com.reactive.app.service.BookService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //    Note: Added log in this method
    @Override
    public Mono<Book> create(Book book) {
        System.out.println(Thread.currentThread().getName());
        Mono<Book> createdBook = bookRepository.save(book).doOnNext(data -> {
            System.out.println(Thread.currentThread().getName());
        });
        return createdBook;
    }

    //    Note: Added log in this method
    @Override
    public Flux<Book> getAll() {
        return bookRepository
                .findAll()
                .delayElements(Duration.ofSeconds(2))
                .log()
                .map(book -> {
                    book.setName(book.getName().toUpperCase());
                    return book;
                });
    }

    @Override
    public Mono<Book> getABookById(Long bookId) {
        Mono<Book> book = bookRepository.findById(bookId);
        return book;
    }

    @Override
    public Mono<Book> updateBookById(Long bookId, Book book) {
        Mono<Book> oldBook = bookRepository.findById(bookId);
        return oldBook.flatMap(book1 -> {
            book1.setName(book.getName());
            book1.setAuthor(book.getAuthor());
            book1.setDescription(book.getDescription());
            book1.setPublisher(book.getPublisher());

            return bookRepository.save(book1);
        });
    }

    @Override
    public Mono<Void> deleteABookById(Long bookId) {
        return bookRepository
                .findById(bookId)
                .flatMap(book -> bookRepository.delete(book));
    }

    @Override
    public Flux<Book> searchBooks(String query) {
        return null;
    }
}
