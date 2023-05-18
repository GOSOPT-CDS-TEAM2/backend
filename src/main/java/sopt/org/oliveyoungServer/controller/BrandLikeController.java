package sopt.org.oliveyoungServer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.oliveyoungServer.common.dto.ApiResponse;
import sopt.org.oliveyoungServer.controller.dto.response.BrandResponseDto;
import sopt.org.oliveyoungServer.domain.Brand;
import sopt.org.oliveyoungServer.domain.BrandLike;
import sopt.org.oliveyoungServer.service.BrandLikeService;
import sopt.org.oliveyoungServer.service.BrandService;
import sopt.org.oliveyoungServer.exception.Success;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BrandLikeController {
    private final BrandLikeService brandLikeService;
    @PostMapping("/brand")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse createAndDelete(@RequestHeader Long userId, @RequestParam("brandId") Long brandId) {
        boolean brandUnLike = brandLikeService.createAndDelete(userId, brandId);
        if (brandUnLike == false) {
            return ApiResponse.success(Success.BRANDLIKE_SUCCESS);
        } else {
            return ApiResponse.success(Success.BRANDUNLIKE_SUCCESS);
        }
    }
}

