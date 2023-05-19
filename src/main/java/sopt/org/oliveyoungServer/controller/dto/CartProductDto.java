package sopt.org.oliveyoungServer.controller.dto;

import lombok.*;


@Getter
public class CartProductDto {
    Long cartProductId;
    String productName;
    int originalPrice;
    int discountPrice;
    String productImgSrc;
    int count;

    public CartProductDto(Long cartProductId, String productName, int originalPrice, int discountRate, String productImgSrc, int count) {
        this.cartProductId = cartProductId;
        this.productName = productName;
        this.originalPrice = originalPrice;
        this.discountPrice = originalPrice - (originalPrice * discountRate / 100);
        this.productImgSrc = productImgSrc;
        this.count = count;
    }
}
