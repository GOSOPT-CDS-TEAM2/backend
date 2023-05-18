package sopt.org.oliveyoungServer.infrastructure;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.oliveyoungServer.controller.dto.response.BrandResponseDto;
import sopt.org.oliveyoungServer.domain.ProductLike;

import java.util.List;
public interface ProductLikeRepository extends JpaRepository<ProductLike, Long>{
    List<ProductLike> findByUserId(Long userId);
}
