package com.sweetener.libraryapp.service;

import com.sweetener.libraryapp.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(int theId);

    Book findByTitle(String title);

    Book save(Book theBook);

    Book deleteByTitle(String title);

    void deleteById(int theId);
}
