package sopt.org.oliveyoungServer.controller.dto.response;

import lombok.Getter;

@Getter
public class CategoryRankingResponseDto {
    private String name;
    private int originalPrice;
    private int discountRate;
    private int discountPrice;
    private String image;
    private Boolean likeTF;

    public CategoryRankingResponseDto(String name, int originalPrice, int discountRate, String image, Boolean likeTF) {
        this.name = name;
        this.originalPrice = originalPrice;
        this.discountRate = discountRate;
        this.discountPrice = (int)originalPrice-originalPrice*discountRate/100;
        this.image = image;
        this.likeTF = likeTF;
    }
}
