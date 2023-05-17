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
    private long orderItemId;
    private int orderCount;

    @Builder
    public CartLine(long orderItemId, int orderCount) {
        this.orderItemId = orderItemId;
        this.orderCount = orderCount;
    }
}
