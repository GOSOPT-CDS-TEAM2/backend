package sopt.org.oliveyoungServer.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sopt.org.oliveyoungServer.controller.dto.CartProductDto;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateCartProductResponse {
    Long cartProductId;
    int count;

    public static UpdateCartProductResponse of(Long cartProductId, int count){
        return new UpdateCartProductResponse(cartProductId, count);
    }
}
