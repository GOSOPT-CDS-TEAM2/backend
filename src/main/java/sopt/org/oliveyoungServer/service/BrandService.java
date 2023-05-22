package sopt.org.oliveyoungServer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.oliveyoungServer.controller.dto.response.BrandResponseDto;
import sopt.org.oliveyoungServer.domain.Brand;
import sopt.org.oliveyoungServer.domain.BrandLike;
import sopt.org.oliveyoungServer.infrastructure.BrandLikeRepository;
import sopt.org.oliveyoungServer.infrastructure.BrandRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;
    private final BrandLikeRepository brandLikeRepository;

    public List<BrandResponseDto> getBrands(Long userId) {
        List<BrandResponseDto> result = new ArrayList<BrandResponseDto>();
        List<Brand> brands = brandRepository.findAll();
        for (Brand brand: brands) {
            Long brandId = brand.getId();
            List<BrandLike> likes = brandLikeRepository.findByUserId(userId);
            Boolean likeTF = false;
            for (BrandLike like: likes) {
                if (like.getBrand().getId() == brandId) {
                    BrandResponseDto brandResponseDto = new BrandResponseDto(brandId, brand.getName(), brand.getImage(), brand.getLogoImage(), true);
                    result.add(brandResponseDto);
                    likeTF = true;
                }
            }
            if (likeTF == false) {
                BrandResponseDto brandResponseDto = new BrandResponseDto(brandId, brand.getName(), brand.getImage(), brand.getLogoImage(), false);
                result.add(brandResponseDto);
            }
        }

        return result;
    }
}
