package sopt.org.oliveyoungServer.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.oliveyoungServer.controller.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
public class CartResponse {

    private int deliveryFee;

    private List<ProductDto> cartProducts = new ArrayList<>();

    @Builder
    public CartResponse(int deliveryFee, List<ProductDto> cartProducts) {
        this.deliveryFee = deliveryFee;
        this.cartProducts = cartProducts;
    }
}
