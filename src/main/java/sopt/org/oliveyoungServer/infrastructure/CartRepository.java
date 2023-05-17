package sopt.org.oliveyoungServer.infrastructure;

import org.springframework.stereotype.Repository;
import sopt.org.oliveyoungServer.controller.dto.request.AddToCartRequest;
import sopt.org.oliveyoungServer.controller.dto.response.CartProductResponse;
import sopt.org.oliveyoungServer.domain.Cart;
import sopt.org.oliveyoungServer.domain.CartLine;

import java.util.List;

@Repository
public interface CartRepository {
    // CREATE
    long createCart(long memberId);

    // UPDATE
    void addItemToCart(long memberId, AddToCartRequest request);

    void modifyOrderCount(long memberId, ModifyOrderCountRequet)
}
