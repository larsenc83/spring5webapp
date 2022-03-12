package com.clarsen.sandbox.udemy.spring.spring5webapp.bootstrap;

import java.util.List;

import com.clarsen.sandbox.udemy.spring.spring5webapp.domain.Author;
import com.clarsen.sandbox.udemy.spring.spring5webapp.domain.Book;
import com.clarsen.sandbox.udemy.spring.spring5webapp.domain.Publisher;
import com.clarsen.sandbox.udemy.spring.spring5webapp.repositories.AuthorRepository;
import com.clarsen.sandbox.udemy.spring.spring5webapp.repositories.BookRepository;
import com.clarsen.sandbox.udemy.spring.spring5webapp.repositories.PublisherRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BooStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Author eric = buildAuthor("eric", "evans");
        Book ddd = buildBook("Domain Driven Design", "123123");
        Publisher publisher = buildPublisher("SFG Publishing", "St Petersburg", "FL");

        publisherRepository.save(publisher);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);

        Author rod = buildAuthor("rod", "johnson");
        Book noEJB = buildBook("J2EE Development with EJB", "456456");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);

        publisher.getBooks().add(ddd);
        publisher.getBooks().add(noEJB);

        authorRepository.saveAll(List.of(eric, rod));
        bookRepository.saveAll(List.of(ddd, noEJB));
        publisherRepository.save(publisher);

        System.out.println("Bootstrap data complete");
        System.out.println("Loaded total publisher data: " + publisherRepository.count());
        System.out.println("Loaded total book data: " + bookRepository.count());
        System.out.println("Loaded total author data: " + authorRepository.count());
    }
    
    private Publisher buildPublisher(String name, String city, String state) {
        return Publisher.builder().name(name).city(city).state(state).build();
    }

    private Author buildAuthor(String first, String last) {
        return Author.builder()
                    .firstName(first)
                    .lastName(last)
                .build();
    }
    
    private Book buildBook(String title, String isbn) {
        return Book.builder()
                    .title(title)
                    .isbn(isbn)
                .build();
    }
}
