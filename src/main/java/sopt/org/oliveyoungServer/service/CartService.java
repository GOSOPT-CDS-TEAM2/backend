package sopt.org.oliveyoungServer.service;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.oliveyoungServer.controller.dto.CartDto;
import sopt.org.oliveyoungServer.controller.dto.CartProductDto;
import sopt.org.oliveyoungServer.domain.Cart;
import sopt.org.oliveyoungServer.domain.CartProduct;
import sopt.org.oliveyoungServer.infrastructure.CartProductRepository;
import sopt.org.oliveyoungServer.infrastructure.CartRepository;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;

    public CartDto getCart(Long userId){
        Cart cart = cartRepository.findByUserId(userId).orElseThrow();
        List<CartProductDto> cartProducts = cartProductRepository.findCartProductDtos(cart.getId());

        return CartDto.builder()
                .cartId(cart.getId())
                .userId(userId)
                .cartProductDtoList(cartProducts)
                .build();
    }

    public Optional<CartProduct> getCartProduct(Long cartProductId){
        Optional<CartProduct> cartProduct = cartProductRepository.findById(cartProductId);
        return cartProduct;
    }

    @Transactional
    public void updateCartProductCount(Long cartProductId, Boolean changeStatus){
        CartProduct cartProduct = cartProductRepository.findById(cartProductId).orElseThrow();
        System.out.println(changeStatus);
        if(changeStatus){
            cartProduct.addCount();
        }
        else{
            cartProduct.subCount();
        }
    }
}
