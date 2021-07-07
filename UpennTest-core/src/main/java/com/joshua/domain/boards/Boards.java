package com.joshua.domain.boards;

import com.joshua.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Boards extends BaseTimeEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length = 500, nullable = false)
    private String title;

    @Column (columnDefinition = "TEXT", nullable = false)
    private String content;

    //@Column
    @ManyToOne
    @JoinColumn (name = "member_id")
    private String author;

    public void update (String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Builder
    public Boards(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}