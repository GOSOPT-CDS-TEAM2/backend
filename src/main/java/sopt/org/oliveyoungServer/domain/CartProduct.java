package sopt.org.oliveyoungServer.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_product_id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product; // 주문 상품


    private int count; // 주문 수량

    @Builder
    public CartProduct(Long id, Cart cart, Product product, int count) {
        this.id = id;
        this.cart = cart;
        this.product = product;
        this.count = count;
    }

    // 장바구니에 담을 상품 엔티티 생성 메소드
    public static CartProduct createCartItem(Cart cart, Product product, int count){
        return CartProduct.builder()
                .cart(cart)
                .product(product)
                .count(count)
                .build();
    }

    // 장바구니 담을 상품 수량 증가
    public void addCount(int count){
        this.count += 1;
    }

    // 장바구니 담을 상품 수량 감소
    public void subCount(int count) {this.count-= 1;}




}
