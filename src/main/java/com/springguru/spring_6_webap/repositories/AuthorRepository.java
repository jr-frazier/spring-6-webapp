package com.springguru.spring_6_webap.repositories;

import com.springguru.spring_6_webap.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
