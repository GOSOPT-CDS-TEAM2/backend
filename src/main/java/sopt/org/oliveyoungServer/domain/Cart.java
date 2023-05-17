package sopt.org.oliveyoungServer.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy="cart", cascade=CascadeType.ALL)
    private List<CartProduct> cartProducts = new ArrayList<>();

    // 연관관계 메서드
    public void setUser(User user){
        this.user = user;
        user.getCarts().add(this);
    }

    public void addCartProduct(CartProduct cartProduct){
        cartProducts.add(cartProduct);
        cartProduct.setCart(this);
    }

}
