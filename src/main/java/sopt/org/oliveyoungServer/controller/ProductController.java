package sopt.org.oliveyoungServer.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.oliveyoungServer.common.dto.ApiResponse;
import sopt.org.oliveyoungServer.controller.dto.request.CategoryRankingRequestDto;
import sopt.org.oliveyoungServer.controller.dto.response.BrandResponseDto;
import sopt.org.oliveyoungServer.controller.dto.response.CategoryRankingResponseDto;
import sopt.org.oliveyoungServer.controller.dto.response.RecommendResponseDto;
import sopt.org.oliveyoungServer.domain.Brand;
import sopt.org.oliveyoungServer.domain.BrandLike;
import sopt.org.oliveyoungServer.service.BrandService;
import sopt.org.oliveyoungServer.exception.Success;
import sopt.org.oliveyoungServer.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/main")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/recommend")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<RecommendResponseDto>> getRecommendProduct(@RequestHeader Long userId){
        List<RecommendResponseDto> response = productService.getRecommendProduct(userId);
        return ApiResponse.success(Success.GETRECOMMEND_SUCESS, response);
    }

    @GetMapping("/ranking")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<CategoryRankingResponseDto>> getCategoryRanking(@RequestHeader Long userId, @RequestBody @Valid final CategoryRankingRequestDto request) {
        String category = request.getCategory();
        return ApiResponse.success(Success.GETCATEGORYRANKING_SUCCESS, productService.getCategoryRanking(userId, category));
    }
}
