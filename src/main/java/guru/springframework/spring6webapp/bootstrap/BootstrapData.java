package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.domain.Seller;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import guru.springframework.spring6webapp.repositories.SellerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final SellerRepository sellerRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository,SellerRepository sellerRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository =publisherRepository;
        this.sellerRepository = sellerRepository ;
    }

    @Override
    public void run(String... args) throws Exception {
        Author solomon = new Author();
        solomon.setFirstName("solomon");
        solomon.setLastName("Bekele");

        Book ddd= new Book();
        ddd.setTitle("Domain driven design");
        ddd.setIsbn("123456");

        Publisher backos = new Publisher();
        backos.setPublisherName("Backos");
        backos.setAddress("Ethiopia");
        backos.setCity("Adiss");
        backos.setState("Ethio");
        backos.setZipcode("123");

        Seller ashe = new Seller();
        ashe.setSellerName("Ashenafi");
        ashe.setLocation("adama");

        Author solomonSaved = authorRepository.save(solomon);
        Book dddSaved = bookRepository.save(ddd);
        Publisher backosSaved = publisherRepository.save(backos);
        Seller asheSaved = sellerRepository.save(ashe);

        Author bereket = new Author();
        bereket.setFirstName("bereket");
        bereket.setLastName("nigussie");

        Book ddd1= new Book();
        ddd1.setTitle("implementing Domain driven design");
        ddd1.setIsbn("8123456");

        Author bereketSaved = authorRepository.save(bereket);
        Book ddd1Saved = bookRepository.save(ddd1);

        solomonSaved.getBooks().add(dddSaved);
        bereketSaved.getBooks().add(ddd1Saved);
        dddSaved.getAuthors().add(solomonSaved);
        ddd1Saved.getAuthors().add(bereketSaved);

//        backosSaved.getBooks().add(dddSaved);
//        backosSaved.getBooks().add(ddd1Saved);
//      relation b/n book and publisher one publisher have many book

        dddSaved.setPublisher(backosSaved);
        ddd1Saved.setPublisher(backosSaved);

        asheSaved.getPublishers().add(backosSaved);
        backosSaved.getSellers().add(asheSaved);


        authorRepository.save(solomonSaved);
        authorRepository.save(bereketSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(ddd1Saved);
        publisherRepository.save(backosSaved);
        sellerRepository.save(asheSaved);

        System.out.println("in bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("book count: " + bookRepository.count());
        System.out.println("publisher count: " + publisherRepository.count());
        System.out.println("seller count: " + sellerRepository.count());

    }
}