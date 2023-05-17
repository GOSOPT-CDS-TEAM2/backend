package sopt.org.oliveyoungServer.domain;

import lombok.Builder;

import javax.persistence.*;

public class ProductLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private long userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private long productId;

    @Builder
    public ProductLike(long userId, long brandId) {
        this.userId = userId;
        this.productId = brandId;
    }
}
