package com.eliasnorrby.spring5webapp.bootstrap;

import com.eliasnorrby.spring5webapp.domain.Author;
import com.eliasnorrby.spring5webapp.domain.Book;
import com.eliasnorrby.spring5webapp.repositories.AuthorRepository;
import com.eliasnorrby.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    var eric = new Author("Eric", "Evans");
    var ddd = new Book("Domain Driven Design", "123123");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    var rod = new Author("Rod", "Johnson");
    var noEJB = new Book("J2EE Development without EJB", "9078743248" );
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);

    authorRepository.save(rod);
    bookRepository.save(noEJB);

    System.out.println("Started in Bootstrap");
    System.out.println("Number of Books: " + bookRepository.count());
  }
}
