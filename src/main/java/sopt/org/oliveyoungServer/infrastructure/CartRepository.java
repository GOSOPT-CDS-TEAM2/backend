package sopt.org.oliveyoungServer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.oliveyoungServer.domain.Cart;

import java.util.Optional;


public interface CartRepository extends JpaRepository<Cart ,Long>{
    Optional<Cart> findByUserId(Long userId);
}
