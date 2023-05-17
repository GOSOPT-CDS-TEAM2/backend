package sopt.org.oliveyoungServer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.oliveyoungServer.domain.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductId(Long productId);
    List<Product> findAll();

}
