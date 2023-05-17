package sopt.org.oliveyoungServer.controller.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.oliveyoungServer.domain.CartLine;

import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
public class CartResponse {

    private Long cartId;

    // User를 참조하는 외래키 역할
    private Long userId;

    private Map<Long, CartLine> cart = new HashMap<>();


}
