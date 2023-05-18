package sopt.org.oliveyoungServer.service;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.oliveyoungServer.controller.dto.CartDto;
import sopt.org.oliveyoungServer.controller.dto.CartProductDto;
import sopt.org.oliveyoungServer.domain.Cart;
import sopt.org.oliveyoungServer.domain.CartProduct;
import sopt.org.oliveyoungServer.domain.Product;
import sopt.org.oliveyoungServer.infrastructure.CartProductRepository;
import sopt.org.oliveyoungServer.infrastructure.CartRepository;





@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;

    public CartDto getCart(Long userId){
        Cart cart = cartRepository.findByUserId(userId).orElseThrow();
        System.out.println(cart.getId());
        List<CartProductDto> cartProducts = cartProductRepository.findCartProductDtos(cart.getId());
        CartDto cartDto = CartDto.builder()
                .cartId(cart.getId())
                .userId(userId)
                .cartProductDtoList(cartProducts)
                .build();
        System.out.println(cartDto.getCartId());

        return cartDto;
    }
}
