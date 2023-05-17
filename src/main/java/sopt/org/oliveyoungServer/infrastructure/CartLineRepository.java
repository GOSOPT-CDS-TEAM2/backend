package sopt.org.oliveyoungServer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.oliveyoungServer.controller.dto.CartLineDto;
import sopt.org.oliveyoungServer.domain.CartLine;

import java.util.List;

public interface CartLineRepository extends JpaRepository<CartLine,Long> {
    List<CartLineDto> findAllByCartId(Long cartId);
    CartLine findByProductId(Long productId);
}
