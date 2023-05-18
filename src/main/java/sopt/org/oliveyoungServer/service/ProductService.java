package sopt.org.oliveyoungServer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.oliveyoungServer.controller.dto.response.CategoryRankingResponseDto;
import sopt.org.oliveyoungServer.domain.Product;
import sopt.org.oliveyoungServer.domain.ProductCategory;
import sopt.org.oliveyoungServer.domain.ProductLike;
import sopt.org.oliveyoungServer.infrastructure.ProductLikeRepository;
import sopt.org.oliveyoungServer.infrastructure.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import static sopt.org.oliveyoungServer.domain.ProductCategory.*;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductLikeRepository productLikeRepository;

    public List<CategoryRankingResponseDto> getCategoryRanking(Long userId,String category) {
        System.out.println(category.equals("향수/디퓨저"));
        List<CategoryRankingResponseDto> result = new ArrayList<CategoryRankingResponseDto>();
        ProductCategory reqCategory = ETC;
        if (category.equals("향수/디퓨저")) {
            reqCategory = PERFUMEANDDEFUSER;
        } else if (category.equals("바디케어")) {
            reqCategory = BODYCARE;
        } else if (category.equals("헤어케어")) {
            reqCategory = HAIRCARE;
        } else if (category.equals("미용소품")) {
            reqCategory = BEAUTYTOOL;
        } else if (category.equals("남성")) {
            reqCategory = MAN;
        } else if (category.equals("식품")) {
            reqCategory = FOOD;
        } else if (category.equals("반려동물")) {
            reqCategory = PET;
        } else {
            reqCategory = ETC;
        }
        List<Product> products = productRepository.findByProductCategory(reqCategory);

        for (int i =0; i<3; i++) {
            Product product = products.get(i);
            List<ProductLike> likes =  productLikeRepository.findByUserId(userId);
            Boolean productLike = false;
            for (ProductLike like: likes) {
                if (like.getProduct().getId() == product.getId()) {
                    CategoryRankingResponseDto categoryRankingResponseDto = new CategoryRankingResponseDto(product.getName(), product.getOriginalPrice(), product.getDiscountRate(), product.getProductImgSrc(), true);
                    result.add(categoryRankingResponseDto);
                    productLike = true;
                }
            }
            if (productLike == false) {
                CategoryRankingResponseDto categoryRankingResponseDto = new CategoryRankingResponseDto(product.getName(), product.getOriginalPrice(), product.getDiscountRate(), product.getProductImgSrc(), false);
                result.add(categoryRankingResponseDto);
            }
        }
        return result;
    }
}
