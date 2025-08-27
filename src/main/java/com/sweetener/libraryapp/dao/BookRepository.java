package com.sweetener.libraryapp.dao;

import com.sweetener.libraryapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findByTitle(String title);

    Book deleteByTitle(String title);
}
