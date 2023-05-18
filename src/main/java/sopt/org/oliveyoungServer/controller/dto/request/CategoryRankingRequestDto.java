package sopt.org.oliveyoungServer.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryRankingRequestDto {
    private String category;
}
