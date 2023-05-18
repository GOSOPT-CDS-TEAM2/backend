package sopt.org.oliveyoungServer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.oliveyoungServer.common.dto.ApiResponse;
import sopt.org.oliveyoungServer.controller.dto.CartDto;
import sopt.org.oliveyoungServer.controller.dto.ProductDto;
import sopt.org.oliveyoungServer.controller.dto.response.CartResponse;

import sopt.org.oliveyoungServer.domain.*;
import sopt.org.oliveyoungServer.exception.Success;
import sopt.org.oliveyoungServer.service.CartService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<CartResponse> getCart(@PathVariable @Valid Long userId){
        CartDto cartDto = cartService.getCart(userId);
        System.out.println(cartDto.getCartId());
        CartResponse cartResponse = CartResponse.of(0, cartDto.getCartProductDtos());
        return ApiResponse.success(Success.GETUSERCART_SUCCESS, cartResponse);
    }
}
