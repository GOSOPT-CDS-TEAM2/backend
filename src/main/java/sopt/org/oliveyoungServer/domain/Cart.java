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
    private Long cartId;

    // User를 참조하는 외래키 역할
    private Long userId;

    @ElementCollection
    @CollectionTable(
            name = "cart_line"
    )
    @MapKeyColumn(name = "map_key")
    private Map<Long, CartLine> cart = new HashMap<>();

    public Cart(long userId){
        this.userId = userId;
    }

    public void addProductToCart(CartLine cartLine) {
        long mapKey = cartLine.getProductId();

        // 기존 아이템이 존재한다면 수량을 더함
        if(cart.containsKey(mapKey)){
            CartLine existCartLine = cart.get(cartLine.getProductId());
            int newOrderCount = existCartLine.getOrderCount() + cartLine.getOrderCount();
            cart.replace(mapKey, CartLine.builder().
                    cartId(cartLine.getCartId()).
                    productId(cartLine.getProductId()).
                    orderCount(newOrderCount).
                    build());
        }
    }

    public void subtractProductToCart(CartLine cartLine){
        long mapKey = cartLine.getProductId();

        // 기존 아이템이 존재한다면 수량을 뺀다
        if(cart.containsKey(mapKey)){
            CartLine existCartLine = cart.get(cartLine.getProductId());
            int newOrderCount = existCartLine.getOrderCount() - cartLine.getOrderCount();
            if(newOrderCount>0) {
                cart.replace(mapKey, CartLine.builder().
                        cartId(cartLine.getCartId()).
                        productId(cartLine.getProductId()).
                        orderCount(newOrderCount).
                        build());
            }
            else{
                // 예외처리 필요
            }
        }
    }

    public void modifyOrderCount(CartLine newCartLine) {
        this.cart.replace(newCartLine.getProductId(), newCartLine);
    }

    public void removeCartLine(Long productId) {
        this.cart.remove(productId);
    }
}
