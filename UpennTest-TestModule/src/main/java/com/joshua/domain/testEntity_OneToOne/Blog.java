package com.joshua.domain.testEntity_OneToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table (name = "blog")
public class Blog {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "no")
    private Integer no;

    @Column (name = "name")
    private String name;

    //양방향을 위한 코드
    @OneToOne (mappedBy = "blog")
    private User user;
}
