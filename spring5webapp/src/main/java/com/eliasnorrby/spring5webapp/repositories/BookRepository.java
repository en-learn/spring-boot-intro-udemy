package com.eliasnorrby.spring5webapp.repositories;

import com.eliasnorrby.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
