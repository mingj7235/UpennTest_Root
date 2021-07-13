package com.joshua.dto.member;

import com.joshua.domain.members.Location;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

@NoArgsConstructor
public class MemberUpdateRequestDto {

    private String name;
    private String password;
    private Location location;

    @Builder

    public MemberUpdateRequestDto(String name, String password, Location location) {
        this.name = name;
        this.password = password;
        this.location = location;
    }
}
