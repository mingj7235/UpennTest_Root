package com.joshua.controller;

import com.joshua.dto.member.MemberSaveRequestDto;
import com.joshua.dto.member.MemberUpdateRequestDto;
import com.joshua.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping ("/api/member/join")
    public Long update (@RequestBody MemberSaveRequestDto requestDto) {
        return memberService.save(requestDto);
    }

    @PutMapping ("/api/member/update/{id}")
    public Long update (@PathVariable Long id, @RequestBody MemberUpdateRequestDto requestDto) {

        return memberService.update(id, requestDto);

    }
}
