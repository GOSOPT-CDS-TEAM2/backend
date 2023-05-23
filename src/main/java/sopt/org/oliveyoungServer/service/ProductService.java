package sopt.org.oliveyoungServer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.oliveyoungServer.controller.dto.response.CategoryRankingResponseDto;
import sopt.org.oliveyoungServer.controller.dto.response.RecommendResponseDto;
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

    public List<RecommendResponseDto> getRecommendProduct(Long userId){
        List<Product> products = productRepository.findAll();
        List<ProductLike> likes = productLikeRepository.findByUserId(userId);
        List<RecommendResponseDto> results = new ArrayList<>();
        boolean check = false;
        for(Product product : products){
            for(ProductLike like: likes){
                if(product.getId().equals(like.getProduct().getId())) {
                    results.add(RecommendResponseDto.of(product.getName(), product.getOriginalPrice(), product.getDiscountRate(), product.getProductImgSrc(), Boolean.TRUE));
                    check = true;
                    break;
                }
            }
            if(!check){
                results.add(RecommendResponseDto.of(product.getName(), product.getOriginalPrice(), product.getDiscountRate(), product.getProductImgSrc(), Boolean.FALSE));
            }
            check = false;
        }

        return results;
    }



    public List<CategoryRankingResponseDto> getCategoryRanking(Long userId,String category) {
        List<CategoryRankingResponseDto> result = new ArrayList<CategoryRankingResponseDto>();
        ProductCategory reqCategory = ETC;
        if (category.equals("perfumeanddefuser")) {
            reqCategory = PERFUMEANDDEFUSER;
        } else if (category.equals("bodycare")) {
            reqCategory = BODYCARE;
        } else if (category.equals("haircare")) {
            reqCategory = HAIRCARE;
        } else if (category.equals("beautytool")) {
            reqCategory = BEAUTYTOOL;
        } else if (category.equals("man")) {
            reqCategory = MAN;
        } else if (category.equals("food")) {
            reqCategory = FOOD;
        } else if (category.equals("pet")) {
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
