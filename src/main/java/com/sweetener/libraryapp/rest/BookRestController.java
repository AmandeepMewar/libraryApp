package com.sweetener.libraryapp.rest;

import com.sweetener.libraryapp.entity.Book;
import com.sweetener.libraryapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookRestController {

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
//
//    @PatchMapping("/books/{bookId}")
//    public Book pathBook(@PathVariable int bookId,
//                         @RequestBody Map<String, Object> patchPayload) {
//        Book tempBook = bookService.findById(bookId);
//
//        // throw exception if null
//        if (tempBook == null) {
//            throw new RuntimeException("Employee id not found - " + bookId);
//        }
//
//        // throw exception if request body contains "id" key
//        if (patchPayload.containsKey("book_id")) {
//            throw new RuntimeException("Book id not allowed in request body - " + bookId);
//        }
//
//        Book patchedBook = apply(patchPayload, tempBook);
//
//        Book dbBook = bookService.save(patchedBook);
//
//        return dbBook;
//    }
}
