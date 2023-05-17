package sopt.org.oliveyoungServer.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long cartId;

    // User를 참조하는 외래키 역할
    private long userId;

    @ElementCollection
    @CollectionTable(
            name = "cart_line"
    )
    private Map<Long, CartLine> cart = new HashMap<>();

    public Cart(long userId){
        this.userId = userId;
    }

    public void addItemToCart(CartLine cartLine) {
        long itemId = cartLine.getOrderItemId();

        if (cart.containsKey(itemId)) {
            int existCartItemOrderCount = cart.get(itemId).getOrderCount();
            int newOrderCount = existCartItemOrderCount + cartLine.getOrderCount();
            cart.replace(itemId, new CartLine(itemId, newOrderCount));
        }
        else {
            cart.put(itemId, cartLine);
        }
    }

    public void modifyOrderCount(CartLine newCartLine) {
        this.cart.replace(newCartLine.getOrderItemId(), newCartLine);
    }

    public void removeCartLine(Long cartItemId) {
        this.cart.remove(cartItemId);
    }
}
