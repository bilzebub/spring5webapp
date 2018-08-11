package com.example.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring5webapp.repositories.AuthorRepository;


@Controller
public class AuthorController {

  private final AuthorRepository authorRepository;

  public AuthorController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @RequestMapping("authors")
  public String getBooks(Model model) {
    model.addAttribute("authors", authorRepository.findAll());
    return "authors";
  }
}
