package sopt.org.oliveyoungServer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.oliveyoungServer.controller.dto.CartDto;
import sopt.org.oliveyoungServer.controller.dto.ProductDto;
import sopt.org.oliveyoungServer.controller.dto.TagDto;
import sopt.org.oliveyoungServer.domain.*;
import sopt.org.oliveyoungServer.infrastructure.CartRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public CartDto getCart(Long userId) {
        Cart cart = cartRepository.findByUserId(userId).orElseThrow();

        if (cart == null) {
            System.out.println("cart null");
        }

        List<ProductDto> productDtos = new ArrayList<>();

        for (CartProduct cartProduct : cart.getCartProducts()) {
            Product product = cartProduct.getProduct();

            if (product != null) {
                List<TagDto> tags = new ArrayList<>();

                for (ProductTag productTag : product.getProductTags()) {
                    tags.add(TagDto.builder()
                            .name(productTag.getTag().getName())
                            .build());
                    System.out.println("============="+tags.get(1));
                }

                productDtos.add(ProductDto.builder()
                        .name(product.getName())
                        .productCategory(product.getProductCategory())
                        .originalPrice(product.getOriginalPrice())
                        .discountRate(product.getDiscountRate())
                        .productImgSrc(product.getProductImgSrc())
                        .productTags(tags)
                        .build());


            } else {
                System.out.println("product null");
            }
        }

        CartDto cartDto = CartDto.builder()
                .userId(userId)
                .cartId(cart.getId())
                .cartProductDtoList(productDtos)
                .build();

        System.out.println(cartDto.getCartId());

        return cartDto;
    }
}
