package sopt.org.oliveyoungServer.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartLine {
    private Long cartId;
    private Long productId;
    private int orderCount;

    @Builder
    public CartLine(long cartId, long productId, int orderCount) {
        this.cartId = cartId;
        this.productId = productId;
        this.orderCount = orderCount;
    }
}
