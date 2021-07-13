package com.joshua.domain.members;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    @OneToOne
    @JoinColumn (name = "MEMBER_ID")
    private Member member;

    public Location(Long id, String location) {
        this.id = id;
        this.location = location;
    }
}
