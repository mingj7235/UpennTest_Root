package com.joshua.domain.testEntity_ManyToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table (name = "book")
public class Book {

    @Id
    @Column (name = "no")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer no;

    @Column (name = "title", nullable = false, length = 200)
    private String title;

    @ManyToOne
    @JoinColumn (name = "category_no")
    private Category category;

}
