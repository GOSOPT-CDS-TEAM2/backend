package sopt.org.oliveyoungServer.controller.dto.response;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RecommendResponseDto {
    private String name;
    private int originalPrice;
    private int discountRate;
    private int discountPrice;
    private String image;
    private Boolean likeTF;

    public static RecommendResponseDto of (String name, int originalPrice, int discountRate, String image, Boolean likeTF) {
        return new RecommendResponseDto(name, originalPrice, discountRate, (int)(originalPrice-originalPrice*discountRate/100), image, likeTF);
    }
}
