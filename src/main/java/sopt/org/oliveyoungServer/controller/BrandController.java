package sopt.org.oliveyoungServer.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.oliveyoungServer.common.dto.ApiResponse;
import sopt.org.oliveyoungServer.controller.dto.response.BrandResponseDto;
import sopt.org.oliveyoungServer.domain.Brand;
import sopt.org.oliveyoungServer.domain.BrandLike;
import sopt.org.oliveyoungServer.service.BrandService;
import sopt.org.oliveyoungServer.exception.Success;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/brand")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<BrandResponseDto>> getBrands(@RequestHeader Long userId) {
        return ApiResponse.success(Success.GETBRAND_SUCCESS, brandService.getBrands(userId));
    }
}
