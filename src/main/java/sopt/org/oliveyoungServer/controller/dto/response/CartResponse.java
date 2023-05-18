package sopt.org.oliveyoungServer.controller.dto.response;

import lombok.*;
import sopt.org.oliveyoungServer.controller.dto.CartProductDto;
import sopt.org.oliveyoungServer.controller.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CartResponse {

    private int deliveryFee;

    private List<CartProductDto> cartProducts = new ArrayList<>();

    public static CartResponse of(int deliveryFee, List<CartProductDto> cartProductDtos){
        return new CartResponse(deliveryFee, cartProductDtos);
    }
}
