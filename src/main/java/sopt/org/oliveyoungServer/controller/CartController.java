package sopt.org.oliveyoungServer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.oliveyoungServer.common.dto.ApiResponse;
import sopt.org.oliveyoungServer.controller.dto.CartDto;
import sopt.org.oliveyoungServer.controller.dto.response.CartResponse;
import sopt.org.oliveyoungServer.exception.Success;
import sopt.org.oliveyoungServer.service.CartService;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<CartResponse> getCart(@RequestHeader @Valid Long userId) {
        CartDto cartDto = cartService.getCart(userId);
        System.out.println(cartDto.getCartId());
        CartResponse cartResponse = CartResponse.of(0, cartDto.getCartProductDtos());
        return ApiResponse.success(Success.GETUSERCART_SUCCESS, cartResponse);
    }
}
