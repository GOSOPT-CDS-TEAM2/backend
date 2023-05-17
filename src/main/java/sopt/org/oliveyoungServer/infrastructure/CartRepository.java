package sopt.org.oliveyoungServer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.oliveyoungServer.domain.Cart;



public interface CartRepository extends JpaRepository<Cart ,Long>{
    Cart findByUserId(Long userId);
}
