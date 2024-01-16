package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller,Long> {
}
