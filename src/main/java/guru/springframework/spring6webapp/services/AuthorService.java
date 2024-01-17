package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.domain.Author;
import org.springframework.stereotype.Service;


public interface AuthorService {

     Iterable<Author>findAll();
}
