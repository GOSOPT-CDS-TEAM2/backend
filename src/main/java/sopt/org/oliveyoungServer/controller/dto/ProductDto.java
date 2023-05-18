package sopt.org.oliveyoungServer.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.oliveyoungServer.domain.Product;
import sopt.org.oliveyoungServer.domain.ProductCategory;
import sopt.org.oliveyoungServer.domain.Tag;

import java.util.List;

@Getter
@NoArgsConstructor
public class ProductDto {
    private String name;

    private ProductCategory productCategory;
    private int originalPrice;

    private int discountPrice;
    private int discountRate;
    private String productImgSrc;
    private List<TagDto> productTags;

    @Builder
    public ProductDto(String name, ProductCategory productCategory, int originalPrice, int discountRate, String productImgSrc, List<TagDto> productTags) {
        this.name = name;
        this.productCategory = productCategory;
        this.originalPrice = originalPrice;
        this.discountPrice = originalPrice*(1-discountRate/100);
        this.discountRate = discountRate;
        this.productImgSrc = productImgSrc;
        this.productTags = productTags;
    }
}
