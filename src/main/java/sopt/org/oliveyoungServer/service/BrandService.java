package sopt.org.oliveyoungServer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.oliveyoungServer.controller.dto.response.BrandResponseDto;
import sopt.org.oliveyoungServer.domain.Brand;
import sopt.org.oliveyoungServer.infrastructure.BrandRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    public List<Brand> getBrand() {
        return brandRepository.findAll();
    }
}
