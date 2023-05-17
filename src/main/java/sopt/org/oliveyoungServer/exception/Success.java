package sopt.org.oliveyoungServer.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Success {
    /**
     200 Ok
     **/
    GETRECOMMEND_SUCESS(HttpStatus.OK,"추천 상품 리스트 조회 성공"),
    GETCATEGORYRANKING_SUCCESS(HttpStatus.OK, "카테고리 랭킹 조회 성공"),
    GETBRAND_SUCCESS(HttpStatus.OK, "브랜드 조회 성공"),
    BRANDLIKE_SUCCESS(HttpStatus.OK, "브랜드 좋아요 성공"),
    BRANDUNLIKE_SUCCESS(HttpStatus.OK, "브랜드 좋아요 취소 성공"),
    GETUSERCART_SUCCESS(HttpStatus.OK, "유저 카트 조회 성공"),
    MODIFYCARTLINEAMOUNT_SUCCESS(HttpStatus.OK, "카트 내 상품 수량 변경 완료");
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}