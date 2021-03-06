package com.Ramuka.spring5webApp.Bootstrap;

import com.Ramuka.spring5webApp.domain.Author;
import com.Ramuka.spring5webApp.domain.Book;
import com.Ramuka.spring5webApp.domain.Publisher;
import com.Ramuka.spring5webApp.repositories.AuthorRepository;
import com.Ramuka.spring5webApp.repositories.BookRepository;
import com.Ramuka.spring5webApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in bootstrap");

        Publisher publisher = new Publisher("Ritik", "Shalimar Bagh", "New Delhi", "Delhi", "110088");
        publisherRepository.save(publisher);

        System.out.println("Number of Publisher " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driver Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books " + bookRepository.count());
        System.out.println("Number of Books by publisher: " + publisher.getBooks().size());
    }
}
