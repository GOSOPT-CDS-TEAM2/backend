package sopt.org.oliveyoungServer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sopt.org.oliveyoungServer.controller.dto.CartProductDto;
import sopt.org.oliveyoungServer.domain.CartProduct;


import java.util.List;
import java.util.Optional;

public interface CartProductRepository extends JpaRepository<CartProduct,Long> {

    // cartProductId로 cartProduct를 가져온다
    Optional<CartProduct> findById(Long Id);


    // 장바구니 페이지에 전달할 CartProductDto를 쿼리로 조회해서 CartProductList에 담는다
    @Query("select new sopt.org.oliveyoungServer.controller.dto.CartProductDto(cp.id, p.name, p.originalPrice, p.discountRate, p.productImgSrc, cp.count) " +
            "from CartProduct cp " +
            "join cp.product p " +
            "where cp.cart.id = :cartId"
    )
    List<CartProductDto> findCartProductDtos(@Param("cartId") Long cartId);


}
