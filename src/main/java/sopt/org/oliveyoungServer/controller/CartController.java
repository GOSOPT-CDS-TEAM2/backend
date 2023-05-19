package sopt.org.oliveyoungServer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.oliveyoungServer.common.dto.ApiResponse;
import sopt.org.oliveyoungServer.controller.dto.CartDto;
import sopt.org.oliveyoungServer.controller.dto.request.UpdateCartProductReqeust;
import sopt.org.oliveyoungServer.controller.dto.response.CartResponse;
import sopt.org.oliveyoungServer.controller.dto.response.UpdateCartProductResponse;
import sopt.org.oliveyoungServer.domain.CartProduct;
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
        CartResponse cartResponse = CartResponse.of(0, cartDto.getCartProductDtos());
        return ApiResponse.success(Success.GETUSERCART_SUCCESS, cartResponse);
    }

    @PatchMapping("/change")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UpdateCartProductResponse> updateCartProductCount(@RequestBody @Valid UpdateCartProductReqeust request){
        cartService.updateCartProductCount(request.getCartProductId(), request.getChagneStatus());
        CartProduct cartProduct = cartService.getCartProduct(request.getCartProductId()).orElse(null);
        UpdateCartProductResponse updateResponse = UpdateCartProductResponse.of((long)request.getCartProductId(), cartProduct.getCount());
        return ApiResponse.success(Success.MODIFYCARTLINEAMOUNT_SUCCESS, updateResponse);
    }
}
