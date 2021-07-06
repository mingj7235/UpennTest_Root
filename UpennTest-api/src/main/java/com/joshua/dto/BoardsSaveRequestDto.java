package com.joshua.dto;

import com.joshua.domain.boards.Boards;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public BoardsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Boards toEntity () {
        return Boards.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
