package com.joshua.dto;

import com.joshua.domain.members.Location;
import com.joshua.domain.members.Member;

public class MemberResponseDto {

    private Long id;
    private String name;
    private String email;
    private Location location;

    public MemberResponseDto (Member entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.location = entity.getLocation();

    }

}
