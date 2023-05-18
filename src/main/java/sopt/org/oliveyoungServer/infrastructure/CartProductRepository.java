package sopt.org.oliveyoungServer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sopt.org.oliveyoungServer.controller.dto.CartProductDto;
import sopt.org.oliveyoungServer.domain.CartProduct;
import sopt.org.oliveyoungServer.domain.Product;


import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProduct,Long> {

    // 카트 아이디와 아이템 아이디를 이용하여 카트 아이템 레포지토리의 엔티티 조회
    List<CartProduct> findAllByCartIdAndProductId(Long cartId, Long productId);

    // 장바구니 페이지에 전달할 CartProductDto를 쿼리로 조회해서 CartProductList에 담는다
    @Query("select new sopt.org.oliveyoungServer.controller.dto.CartProductDto(cp.id, p.name, p.originalPrice, p.discountRate, p.productImgSrc, cp.count) " +
            "from CartProduct cp " +
            "join cp.product p " +
            "where cp.cart.id = :cartId"
    )
    List<CartProductDto> findCartProductDtos(@Param("cartId") Long cartId);


}
