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

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.FOUND)
    public ApiResponse<CartResponse> getCart(@PathVariable @Valid Long userId){
        CartDto cart = cartService.getCart(userId);
        System.out.println("===========");
        System.out.println(cart.getCartId());
        System.out.println("===========");
        CartResponse cartResponse = CartResponse.builder().
                deliveryFee(0).
                cartProducts(cart.getProductDtoList()).
                build();
        return ApiResponse.success(Success.GETUSERCART_SUCCESS, cartResponse);
    }
}
