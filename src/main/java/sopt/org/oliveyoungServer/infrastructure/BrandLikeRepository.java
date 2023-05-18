package sopt.org.oliveyoungServer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.org.oliveyoungServer.domain.BrandLike;

import java.util.List;

public interface BrandLikeRepository extends JpaRepository<BrandLike, Long> {
    List<BrandLike> findByUserId(Long userId);

}
