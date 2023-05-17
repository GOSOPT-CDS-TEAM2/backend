package sopt.org.oliveyoungServer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.oliveyoungServer.common.dto.ApiResponse;
import sopt.org.oliveyoungServer.controller.dto.CartDto;
import sopt.org.oliveyoungServer.controller.dto.response.CartResponse;

import sopt.org.oliveyoungServer.exception.Success;
import sopt.org.oliveyoungServer.service.CartProductService;
import sopt.org.oliveyoungServer.service.CartService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<CartResponse> getCart(@RequestParam @Valid Long userId){
        Optional<CartDto> cart = cartService.getCartProduct(userId);
        CartResponse cartResponse = CartResponse.builder().
                deliveryFee(0).
                cartProducts(cart.get().getProductDtoList()).
                build();
        return ApiResponse.success(Success.GETUSERCART_SUCCESS, cartResponse);
    }
}
