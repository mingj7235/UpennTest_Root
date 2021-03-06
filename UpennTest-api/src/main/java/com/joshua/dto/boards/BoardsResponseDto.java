package com.joshua.dto.boards;

import com.joshua.domain.boards.Boards;
import com.joshua.domain.members.Member;
import lombok.Getter;

@Getter
public class BoardsResponseDto {

    private Long id;
    private String title;
    private String content;
    //private Member author;
    private String author;

    public BoardsResponseDto(Boards entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
