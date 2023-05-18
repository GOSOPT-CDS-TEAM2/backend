package sopt.org.oliveyoungServer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.oliveyoungServer.controller.dto.response.BrandResponseDto;
import sopt.org.oliveyoungServer.domain.Brand;
import sopt.org.oliveyoungServer.domain.BrandLike;
import sopt.org.oliveyoungServer.domain.User;
import sopt.org.oliveyoungServer.infrastructure.BrandLikeRepository;
import sopt.org.oliveyoungServer.infrastructure.BrandRepository;
import sopt.org.oliveyoungServer.infrastructure.UserRepository;
import sopt.org.oliveyoungServer.exception.Error;
import sopt.org.oliveyoungServer.exception.model.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandLikeService {
    private final BrandLikeRepository brandLikeRepository;
    private final UserRepository userRepository;
    private final BrandRepository brandRepository;

    public boolean createAndDelete(Long userId, Long brandId) {
        List <BrandLike> brandLikes = brandLikeRepository.findByUserId(userId);

        boolean brandUnLike = false;

        for (BrandLike brandLike: brandLikes) {
            if (brandLike.getBrand().getId()==brandId) {
                brandLikeRepository.delete(brandLike);
                brandUnLike = true;
                return brandUnLike;
            }
        }
        if (brandUnLike == false) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));
            Brand brand = brandRepository.findById(brandId)
                    .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_BRAND_EXCEPTION, Error.NOT_FOUND_BRAND_EXCEPTION.getMessage()));

            BrandLike newBrandLike = BrandLike.newInstance(user, brand);

            brandLikeRepository.save(newBrandLike);
            return brandUnLike;
        }
        return brandUnLike;
    }

}