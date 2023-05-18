package sopt.org.oliveyoungServer.infrastructure;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.oliveyoungServer.domain.Product;
import sopt.org.oliveyoungServer.domain.ProductCategory;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long>{
    List<Product> findByProductCategory(ProductCategory productCategory);
}
