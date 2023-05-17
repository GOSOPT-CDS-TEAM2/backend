package sopt.org.oliveyoungServer.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.oliveyoungServer.domain.Tag;

import java.util.List;

@Getter
@NoArgsConstructor
public class CartLineDto {
    private String name;
    private int originalPrice;

    private int discountRate;
    private int discountPrice;
    private int discountAmount;
    private String image;
    private List<Tag> tags;

    @Builder
    public CartLineDto(String name, int originalPrice, int discountRate, int discountAmount, String image, List<Tag> tags) {
        this.name = name;
        this.originalPrice = originalPrice;
        this.discountRate = discountRate;
        this.discountPrice = originalPrice*(discountRate/100);
        this.discountAmount = discountAmount;
        this.image = image;
        this.tags = tags;
    }
}
