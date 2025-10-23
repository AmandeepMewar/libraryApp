package com.sweetener.libraryapp.service;

import com.sweetener.libraryapp.dao.BookRepository;
import com.sweetener.libraryapp.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository theBookRepository) {
        bookRepository = theBookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int theId) {
        Optional<Book> result = bookRepository.findById(theId);
        Book theBook = null;

        if (result.isPresent()) {
            theBook = result.get();
        }else {
            throw new RuntimeException("Did not find Book id - " + theId);
        }

        return theBook;
    }

    @Override
    public Book findByTitle(String title){

        Book theBook = bookRepository.findByTitle(title);

        return theBook;
    }

    @Override
    public Book save(Book theBook) {
        return bookRepository.save(theBook);
    }

    @Override
    public Book deleteByTitle(String title) {

        Book theBook = bookRepository.deleteByTitle(title);

        if (theBook != null) {
            return theBook;
        } else {
            throw new RuntimeException("Did not find Book title - " + title);
        }
    }

    @Override
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);
    }
}
