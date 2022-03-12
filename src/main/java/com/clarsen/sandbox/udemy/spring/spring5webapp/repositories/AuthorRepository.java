package com.clarsen.sandbox.udemy.spring.spring5webapp.repositories;

import com.clarsen.sandbox.udemy.spring.spring5webapp.domain.Author;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
