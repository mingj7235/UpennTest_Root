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

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @ManyToOne
    //지연로딩. 즉, 필요할때만 가져오도록. 성능!
    //LAZY의 사용은 proxy를 통해 조회가되며, 실제로 사용하는 시점에 DB를 조회하도록 하는 것이다.
    @JoinColumn (name = "LOCATION_ID")
    private Location location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;



    @Builder
    public Member(String name, String email, String picture, Location location, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.location = location;
        this.role = role;
    }



    public Member update (String name, String picture, Location location) {
        this.name = name;
        this.picture = picture;
        this.location = location;

        return this;
    }

    public String getRoleKey () {
        return this.role.getKey();
    }
}
