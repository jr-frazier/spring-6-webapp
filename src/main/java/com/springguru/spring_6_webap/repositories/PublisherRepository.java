package com.springguru.spring_6_webap.repositories;

import com.springguru.spring_6_webap.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
