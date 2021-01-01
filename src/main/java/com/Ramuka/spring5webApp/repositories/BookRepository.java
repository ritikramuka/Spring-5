package com.Ramuka.spring5webApp.repositories;

import com.Ramuka.spring5webApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
