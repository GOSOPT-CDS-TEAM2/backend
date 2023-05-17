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
    @MapKeyColumn(name = "map_key")
    private Map<Long, CartLine> cart = new HashMap<>();

    public Cart(long userId){
        this.userId = userId;
    }

    public void addItemToCart(CartLine cartLine) {
        long mapKey = cartLine.getItemId();

        // 기존 아이템이 존재한다면 수량을 더함
        if(cart.containsKey(mapKey)){
            CartLine existCartLine = cart.get(cartLine.getItemId());
            int newOrderCount = existCartLine.getOrderCount() + cartLine.getOrderCount();
            cart.replace(mapKey, CartLine.builder().
                    cartId(cartLine.getCartId()).
                    itemId(cartLine.getItemId()).
                    orderCount(newOrderCount).
                    build());
        }
    }

    public void modifyOrderCount(CartLine newCartLine) {
        this.cart.replace(newCartLine.getOrderItemId(), newCartLine);
    }

    public void removeCartLine(Long cartItemId) {
        this.cart.remove(cartItemId);
    }
}
