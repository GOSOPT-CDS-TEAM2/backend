package sopt.org.oliveyoungServer.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String logoImage;

    @Builder
    private Brand(String name, String image, String logoImage) {
        this.name = name;
        this.image = image;
        this.logoImage = logoImage;
    }
}
