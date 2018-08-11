package com.example.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.spring5webapp.model.Author;
import com.example.spring5webapp.model.Book;
import com.example.spring5webapp.model.Publisher;
import com.example.spring5webapp.repositories.AuthorRepository;
import com.example.spring5webapp.repositories.BookRepository;
import com.example.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public DevBootstrap(AuthorRepository authorRepository,
                      BookRepository bookRepository,
                      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    initData();
  }

  private void initData() {

    Publisher harper = new Publisher("Harper Collins", "Harper address");
    Publisher worx = new Publisher("Worx", "Worx address");

    publisherRepository.save(harper);
    publisherRepository.save(worx);

    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "1234", harper);
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    Author rod = new Author("Rod", "Johnson");
    Book noEjb = new Book("J2EE Development without EJB", "23444", worx);
    rod.getBooks().add(noEjb);
    noEjb.getAuthors().add(rod);

    authorRepository.save(rod);
    bookRepository.save(noEjb);

  }


}
