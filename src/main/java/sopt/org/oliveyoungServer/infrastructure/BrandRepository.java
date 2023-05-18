package sopt.org.oliveyoungServer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.oliveyoungServer.controller.dto.response.BrandResponseDto;
import sopt.org.oliveyoungServer.domain.Brand;

import java.util.List;

public interface BrandRepository extends JpaRepository <Brand, Long> {
    List<Brand> findAll();

}
