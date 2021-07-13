package com.joshua.domain.members;


import com.joshua.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    //지연로딩. 즉, 필요할때만 가져오도록. 성능!
    //LAZY의 사용은 proxy를 통해 조회가되며, 실제로 사용하는 시점에 DB를 조회하도록 하는 것이다.
    @JoinColumn (name = "LOCATION_ID")
    private Location location;

    @Builder
    public Member(String name, String email, String password, Location location) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.location = location;
    }

    public Member update (String name, String password, Location location) {
        this.name = name;
        this.password = password;
        this.location = location;
        return this;
    }



}
