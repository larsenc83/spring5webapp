package com.clarsen.sandbox.udemy.spring.spring5webapp.repositories;

import com.clarsen.sandbox.udemy.spring.spring5webapp.domain.Publisher;

import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}