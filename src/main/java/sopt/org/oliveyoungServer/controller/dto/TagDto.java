package sopt.org.oliveyoungServer.controller.dto;

import lombok.Builder;

public class TagDto {
    private String name;

    @Builder
    public TagDto(String name) {
        this.name = name;
    }
}
