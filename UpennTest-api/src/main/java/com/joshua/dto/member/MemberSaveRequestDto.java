package com.joshua.dto.member;

import com.joshua.domain.members.Location;
import com.joshua.domain.members.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {
    String name;
    String email;
    String password;
    Location location;

    @Builder
    public MemberSaveRequestDto(String name, String email, String password, Location location) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.location = location;
    }

    public Member toEntity () {
        return Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .location(location)
                .build();
    }
}
