package com.joshua.dto;

import com.joshua.domain.boards.Boards;
import lombok.Getter;

@Getter
public class BoardsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public BoardsResponseDto(Boards entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
