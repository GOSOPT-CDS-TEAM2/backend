package sopt.org.oliveyoungServer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.oliveyoungServer.common.dto.ApiResponse;
import sopt.org.oliveyoungServer.controller.dto.response.CartResponse;
import sopt.org.oliveyoungServer.service.CartLineService;
import sopt.org.oliveyoungServer.service.CartService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final CartLineService cartLineService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<CartResponse>
}
