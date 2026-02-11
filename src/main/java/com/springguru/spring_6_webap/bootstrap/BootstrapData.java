package com.springguru.spring_6_webap.bootstrap;

import com.springguru.spring_6_webap.domain.Author;
import com.springguru.spring_6_webap.domain.Book;
import com.springguru.spring_6_webap.domain.Publisher;
import com.springguru.spring_6_webap.repositories.AuthorRepository;
import com.springguru.spring_6_webap.repositories.BookRepository;
import com.springguru.spring_6_webap.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("No EJB");
        noEJB.setIsbn("978-0321349603");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("978-0321125215");

        Author savedEricAuthor = authorRepository.save(eric);
        Book savedDDDBook = bookRepository.save(ddd);
        savedDDDBook.getAuthors().add(savedEricAuthor);
        savedEricAuthor.getBooks().add(savedDDDBook);


        Author savedRodAuthor = authorRepository.save(rod);
        Book savedNoEJBBook = bookRepository.save(noEJB);
        savedNoEJBBook.getAuthors().add(savedRodAuthor);
        savedRodAuthor.getBooks().add(savedNoEJBBook);

        savedEricAuthor.getBooks().add(savedDDDBook);
        savedRodAuthor.getBooks().add(savedNoEJBBook);

        Publisher publisher = new Publisher();
        publisher.setName("O'Reilly");
        publisher.setCity("Sebastopol");
        publisher.setState("CA");
        publisher.setZipCode("95472");
        publisher.setAddress("123 Main St.");
        Publisher savedPublisher = publisherRepository.save(publisher);

        ddd.setPublisher(savedPublisher);
        noEJB.setPublisher(savedPublisher);

        savedDDDBook.setPublisher(publisher);


        authorRepository.save(savedEricAuthor);
        authorRepository.save(savedRodAuthor);
        bookRepository.save(savedDDDBook);
        bookRepository.save(savedNoEJBBook);

        System.out.println("Bootstrap data loaded");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
