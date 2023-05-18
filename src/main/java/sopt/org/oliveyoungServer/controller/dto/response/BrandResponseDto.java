package sopt.org.oliveyoungServer.controller.dto.response;

public class BrandResponseDto {
    private Long id;
    private String name;
    private String image;
    private String logoImage;
    private Boolean likeTF;

    public BrandResponseDto(Long id,String name, String image, String logoImage, Boolean likeTF) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.logoImage = logoImage;
        this.likeTF = likeTF;
    }

}
