package com.joshua.domain.testEntity_OneToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table (name = "user")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "no")
    private Integer no;

    @Column (name = "id")
    private String id;

    @OneToOne
    @JoinColumn(name = "blog_no")
    private Blog blog;

}
