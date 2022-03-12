package com.clarsen.sandbox.udemy.spring.spring5webapp.bootstrap;

import com.clarsen.sandbox.udemy.spring.spring5webapp.domain.Author;
import com.clarsen.sandbox.udemy.spring.spring5webapp.domain.Book;
import com.clarsen.sandbox.udemy.spring.spring5webapp.repositories.AuthorRepository;
import com.clarsen.sandbox.udemy.spring.spring5webapp.repositories.BookRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BooStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BooStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = buildAuthor("eric", "evans");
        Book ddd = buildBook("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = buildAuthor("rod", "johnson");
        Book noEJB = buildBook("J2EE Development with EJB", "456456");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Bootstrap data complete");
        System.out.println("Loaded total book data: " + bookRepository.count());
        System.out.println("Loaded total author data: " + authorRepository.count());
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
