package com.joshua.dto;

import com.joshua.domain.members.Location;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

@NoArgsConstructor
public class MemberUpdateRequestDto {

    private String name;
    private String picture;
    private Location location;

    @Builder

    public MemberUpdateRequestDto(String name, String picture, Location location) {
        this.name = name;
        this.picture = picture;
        this.location = location;
    }
}
