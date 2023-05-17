package sopt.org.oliveyoungServer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.oliveyoungServer.domain.CartProduct;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {

}
