package sopt.org.oliveyoungServer.controller.dto.request;

import lombok.Getter;

import javax.validation.constraints.Min;

@Getter
public class AddToCartRequest {
    private long itemId;
    @Min(1)
    private int orderCount;
}
