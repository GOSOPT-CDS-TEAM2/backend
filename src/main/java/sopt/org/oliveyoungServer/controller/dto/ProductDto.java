package sopt.org.oliveyoungServer.controller.dto;

import lombok.*;
import sopt.org.oliveyoungServer.domain.ProductCategory;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDto {
    private String name;

    private ProductCategory productCategory;
    private int originalPrice;

    private int discountPrice;
    private int discountRate;
    private String productImgSrc;

    public static ProductDto of(String name, ProductCategory productCategory, int originalPrice, int discountRate, String productImgSrc){
        int discountPrice = originalPrice * (1-discountRate/100);
        ProductDto productDto = new ProductDto(name, productCategory, originalPrice, discountPrice, discountRate, productImgSrc);
        return productDto;
    }
}
