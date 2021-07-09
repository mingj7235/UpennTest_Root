package com.joshua.domain.members;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Location {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    @OneToMany (mappedBy = "location")
    List<Member> members = new ArrayList<Member>();

}
