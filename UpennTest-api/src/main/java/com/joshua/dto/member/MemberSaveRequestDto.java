package com.joshua.dto.member;

import com.joshua.domain.members.Location;
import com.joshua.domain.members.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSaveRequestDto {
    String name;
    String email;
    String password;
    Long location_id;

    @Builder
    public MemberSaveRequestDto(String name, String email, String password, Long location_id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.location_id = location_id;
    }

    public Member toEntity () {
        return Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
