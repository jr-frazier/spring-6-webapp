package com.springguru.spring_6_webap.services;

import com.springguru.spring_6_webap.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
