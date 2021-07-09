package com.joshua.controller;

import com.joshua.dto.MemberUpdateRequestDto;
import com.joshua.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberApiController {
    private final MemberService memberService;

    @PutMapping ("/api/member/update/{id}")
    public Long update (@PathVariable Long id, @RequestBody MemberUpdateRequestDto requestDto) {

        return memberService.
    }
}
