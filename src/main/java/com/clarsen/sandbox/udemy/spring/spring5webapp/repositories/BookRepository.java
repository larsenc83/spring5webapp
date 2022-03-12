package com.clarsen.sandbox.udemy.spring.spring5webapp.repositories;

import com.clarsen.sandbox.udemy.spring.spring5webapp.domain.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
