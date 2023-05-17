package sopt.org.oliveyoungServer.controller.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.oliveyoungServer.domain.ProductTag;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class CartProductResponse {

    @NotBlank
    private String name;

    @NotBlank
    private int originalPrice;

    @NotBlank
    private int discountRate;

    private List<ProductTag> productTags;

    @NotBlank
    private int productAmount;

    @Builder
    public CartProductResponse(String name, int originalPrice, int discountRate, List<ProductTag> productTags, int productAmount) {
        this.name = name;
        this.originalPrice = originalPrice;
        this.discountRate = discountRate;
        this.productTags = productTags;
        this.productAmount = productAmount;
    }
}
