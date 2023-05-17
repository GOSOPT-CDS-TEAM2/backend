package sopt.org.oliveyoungServer.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CartDto {
    private Long cartId;
    private Long userId;

    private List<ProductDto> productDtoList;

    @Builder

    public CartDto(Long cartId, Long userId, List<ProductDto> cartProductDtoList) {
        this.cartId = cartId;
        this.userId = userId;
        this.productDtoList = cartProductDtoList;
    }
}
