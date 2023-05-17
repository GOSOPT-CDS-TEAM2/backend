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
    private long cartId;
    private long itemId;
    private int orderCount;

    @Builder
    public CartLine(long cartId, long itemId, int orderCount) {
        this.cartId = cartId;
        this.itemId = itemId;
        this.orderCount = orderCount;
    }
}
