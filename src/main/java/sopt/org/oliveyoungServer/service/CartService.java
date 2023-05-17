package sopt.org.oliveyoungServer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.oliveyoungServer.controller.dto.CartDto;
import sopt.org.oliveyoungServer.controller.dto.ProductDto;
import sopt.org.oliveyoungServer.controller.dto.TagDto;
import sopt.org.oliveyoungServer.domain.*;
import sopt.org.oliveyoungServer.infrastructure.CartRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Optional<CartDto> getCartProduct(Long userId){
        Cart cart = cartRepository.findByUserId(userId);
        List<TagDto> tags = new ArrayList<>();
        List<ProductDto> productDtos = new ArrayList<>();

        for(CartProduct cartProduct : cart.getCartProducts()){
            Product product = cartProduct.getProduct();

            for(ProductTag productTag : product.getProductTags()){
                tags.add(TagDto.builder().name(productTag.getTag().getName()).build());
            }

            ProductDto productDto = ProductDto.builder().
                    name(product.getName()).
                    originalPrice(product.getOriginalPrice()).
                    discountRate(product.getDiscountRate()).
                    productCategory(product.getProductCategory()).
                    productImgSrc(product.getProductImgSrc()).
                    productTags(tags)
                    .build();

            productDtos.add(productDto);
        }

        CartDto cartDto = CartDto.builder().
                        userId(userId).
                        cartId(cart.getId()).
                        cartProductDtoList(productDtos).
                        build();

        return Optional.of(cartDto);
    }
}
