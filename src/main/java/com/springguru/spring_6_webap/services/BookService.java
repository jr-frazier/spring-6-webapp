package com.springguru.spring_6_webap.services;

import com.springguru.spring_6_webap.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
