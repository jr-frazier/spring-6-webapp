package com.springguru.spring_6_webap.repositories;

import com.springguru.spring_6_webap.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
