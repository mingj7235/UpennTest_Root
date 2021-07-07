package com.joshua.dto;

import com.joshua.domain.boards.Boards;
import com.joshua.domain.members.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardsListResponseDto {
    private Long id;
    private String title;
    private String author;
    //private Member author;
    private LocalDateTime modifiedDate;

    public BoardsListResponseDto(Boards entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
