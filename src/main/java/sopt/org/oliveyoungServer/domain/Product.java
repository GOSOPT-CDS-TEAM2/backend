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
    private long id;

    private String name;

    // category enum 필요
    @Enumerated(value = EnumType.STRING)
    @Column(name = "product_category", nullable = false)
    private ProductCategory productCategory;
    private int originalPrice;

    private int discountRate;

    private String productImgSrc;

    @OneToMany(mappedBy = "product")
    private List<ProductTag> productTags = new ArrayList<ProductTag>();
    @Builder
    public Product(String name, ProductCategory productCategory, int originalPrice, int discountRate, String productImgSrc, List<ProductTag> productTags) {
        this.name = name;
        this.productCategory = productCategory;
        this.originalPrice = originalPrice;
        this.discountRate = discountRate;
        this.productImgSrc = productImgSrc;
        this.productTags = productTags;
    }
}
