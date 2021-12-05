package fabio.springframework.demo;

import fabio.springframework.demo.domain.Author;
import fabio.springframework.demo.domain.Book;
import fabio.springframework.demo.domain.Publisher;
import fabio.springframework.demo.repositories.AuthorRepository;
import fabio.springframework.demo.repositories.BookRepository;
import fabio.springframework.demo.repositories.PublisherRepository;
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
        Publisher pub = new Publisher("Fabio", "Koesterkamp 29");
        publisherRepository.save(pub);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123456");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        pub.getBooks().add(ddd);
        ddd.setPublisher(pub);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pub);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "654321");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        pub.getBooks().add(noEJB);
        noEJB.setPublisher(pub);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(pub);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + pub.getBooks().size());
    }
}
