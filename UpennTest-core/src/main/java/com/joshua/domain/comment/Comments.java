package com.joshua.domain.comment;

import com.joshua.domain.boards.Boards;

import javax.persistence.*;

@Entity
public class Comments {

    @Id @GeneratedValue @Column (name = "comment_id")
    private Long id;

    private String title;
    private String content;
    private String writer;

    @ManyToOne
    @JoinColumn (name = "boards_id")
    private Boards boards;
}
