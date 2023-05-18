package sopt.org.oliveyoungServer.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;

    // category enum 필요
    @Enumerated(value = EnumType.STRING)
    @Column(name = "product_category", nullable = false)
    private ProductCategory productCategory;
    private int originalPrice;

    private int discountRate;

    private String productImgSrc;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartProduct> cartProducts = new ArrayList<>();

    @Builder
    public Product(String name, ProductCategory productCategory, int originalPrice, int discountRate, String productImgSrc) {
        this.name = name;
        this.productCategory = productCategory;
        this.originalPrice = originalPrice;
        this.discountRate = discountRate;
        this.productImgSrc = productImgSrc;
    }
}
