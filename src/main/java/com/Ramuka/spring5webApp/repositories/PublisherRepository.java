package com.Ramuka.spring5webApp.repositories;

import com.Ramuka.spring5webApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
