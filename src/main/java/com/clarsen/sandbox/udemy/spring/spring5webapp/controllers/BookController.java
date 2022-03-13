package com.clarsen.sandbox.udemy.spring.spring5webapp.controllers;

import com.clarsen.sandbox.udemy.spring.spring5webapp.repositories.BookRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    
    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }
}
