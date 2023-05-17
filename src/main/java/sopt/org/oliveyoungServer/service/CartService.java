package sopt.org.oliveyoungServer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.oliveyoungServer.controller.dto.CartLineDto;
import sopt.org.oliveyoungServer.controller.dto.response.CartProductResponse;
import sopt.org.oliveyoungServer.domain.Cart;
import sopt.org.oliveyoungServer.domain.CartLine;
import sopt.org.oliveyoungServer.infrastructure.CartLineRepository;
import sopt.org.oliveyoungServer.infrastructure.CartRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartLineRepository cartLineRepository;

    void addProduct(Long userId, Long productId){
        Cart cart = cartRepository.findByUserId(userId);
        CartLine cartLine = cartLineRepository.findByProductId(productId);
        cart.addProductToCart(cartLine);
    }
    void subtractProduct(Long userId, Long productId){
        Cart cart = cartRepository.findByUserId(userId);
        CartLine cartLine = cartLineRepository.findByProductId(productId);
        cart.subtractProductToCart(cartLine);
    }
}
