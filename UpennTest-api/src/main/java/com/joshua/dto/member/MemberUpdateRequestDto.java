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
    private Long location_id;

    @Builder
    public MemberUpdateRequestDto(String name, String password, Long location_id) {
        this.name = name;
        this.password = password;
        this.location_id = location_id;
    }
}
