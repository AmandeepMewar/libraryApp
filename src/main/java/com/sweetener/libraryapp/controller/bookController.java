package com.sweetener.libraryapp.controller;

import com.sweetener.libraryapp.entity.Book;
import com.sweetener.libraryapp.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class bookController {

    private BookService bookService;

    public bookController(BookService theBookService) {
        bookService = theBookService;
    }

    @GetMapping("/book")
    public String booklist(@RequestParam String title, Model theModel) {

        Book theBooks = bookService.findByTitle(title);

        theModel.addAttribute("book", theBooks);
        theModel.addAttribute("title", '"' + title + '"');

        return "searchbook";
    }

    @GetMapping("/booklist")
    public String booklist(Model theModel) {

        List<Book> theBooks = bookService.findAll();

        theModel.addAttribute("books", theBooks);

        return "booklist";
    }

    @GetMapping("/updateBook")
    public String updateBook(@RequestParam("bookId") int theId, Model theModel) {

        Book theBook = bookService.findById(theId);

        theModel.addAttribute("book", theBook);

        return "updateBook";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") int theId) {
        bookService.deleteById(theId);

        return "redirect:/booklist";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book theBook) {

        bookService.save(theBook);

        return "redirect:/booklist";
    }
}

