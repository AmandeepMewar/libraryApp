package com.sweetener.libraryapp.controller;

import com.sweetener.libraryapp.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class demoController {

    private BookService bookService;

    public demoController(BookService theBookService) {
        bookService = theBookService;
    }

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

}
