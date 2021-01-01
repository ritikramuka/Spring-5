package com.Ramuka.spring5webApp.repositories;

import com.Ramuka.spring5webApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
