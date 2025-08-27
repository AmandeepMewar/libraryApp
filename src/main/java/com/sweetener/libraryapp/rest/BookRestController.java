package com.sweetener.libraryapp.rest;

import com.sweetener.libraryapp.entity.Book;
import com.sweetener.libraryapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController  {

    private BookService bookService;

    @Autowired
    public BookRestController(BookService theBookService) {
        bookService = theBookService;
    }

    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/books/{title}")
    public Book findByTitle(@PathVariable String title) {
        return bookService.findByTitle(title);
    }

    @DeleteMapping("/books/{title}")
    public Book deleteByTitle(@PathVariable String title) {
        return bookService.deleteByTitle(title);
    }
}
