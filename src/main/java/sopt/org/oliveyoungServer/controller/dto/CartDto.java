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

    private List<CartProductDto> cartProductDtos;

    @Builder
    public CartDto(Long cartId, Long userId, List<CartProductDto> cartProductDtoList) {
        this.cartId = cartId;
        this.userId = userId;
        this.cartProductDtos = cartProductDtoList;
    }
}
