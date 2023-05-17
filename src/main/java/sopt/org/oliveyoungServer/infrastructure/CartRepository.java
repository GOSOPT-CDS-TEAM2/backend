package sopt.org.oliveyoungServer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.org.oliveyoungServer.controller.dto.CartLineDto;
import sopt.org.oliveyoungServer.controller.dto.request.AddToCartRequest;
import sopt.org.oliveyoungServer.controller.dto.response.CartProductResponse;
import sopt.org.oliveyoungServer.domain.Cart;
import sopt.org.oliveyoungServer.domain.CartLine;

import java.util.List;


public interface CartRepository extends JpaRepository<Cart ,Long>{
    Cart findByUserId(Long userId);
    void addProduct(Long userId, Long productId);
    void subtractProduct(Long userId, Long productId);
}
