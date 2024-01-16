package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.logging.LogManager;

public interface BookRepository extends CrudRepository<Book, Long> {
}
