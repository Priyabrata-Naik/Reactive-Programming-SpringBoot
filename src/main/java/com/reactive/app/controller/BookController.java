package com.reactive.app.controller;

import com.reactive.app.entity.Book;
import com.reactive.app.service.BookService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Mono<Book> create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @GetMapping
    public Flux<Book> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{bookId}")
    public Mono<Book> getABookById(@PathVariable Long bookId) {
        return bookService.getABookById(bookId);
    }

    @PutMapping("/{bookId}")
    public Mono<Book> updateBookById(@PathVariable Long bookId, @RequestBody Book book) {
        return bookService.updateBookById(bookId, book);
    }

    @DeleteMapping("/{bookId}")
    public Mono<Void> deleteBookById(@PathVariable Long bookId) {
        return bookService.deleteABookById(bookId);
    }


}
