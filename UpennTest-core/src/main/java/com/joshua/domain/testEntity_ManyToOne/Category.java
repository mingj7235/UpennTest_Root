package com.joshua.domain.testEntity_ManyToOne;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table (name = "category")
public class Category {

    @Id
    @Column (name = "no")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer no;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToMany (mappedBy = "category")
    private List<Book> books = new ArrayList<Book>();
}


