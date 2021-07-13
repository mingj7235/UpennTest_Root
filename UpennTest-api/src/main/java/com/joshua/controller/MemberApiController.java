package com.joshua.controller;

import com.joshua.dto.member.MemberSaveRequestDto;
import com.joshua.dto.member.MemberUpdateRequestDto;
import com.joshua.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberApiController {
    private final MemberService memberService;

    @PostMapping ("/api/member/join")
    public Long join (MemberSaveRequestDto requestDto) {
        System.out.println("이름 : " + requestDto.getName());
        return memberService.save(requestDto);
    }

//    @PostMapping ("/api/member/login")
//    public Long login (@RequestBody MemberLoginRequestDto requestDto) {
//    }

    @PutMapping ("/api/member/update/{id}")
    public Long update (@PathVariable Long id, MemberUpdateRequestDto requestDto) {

        return memberService.update(id, requestDto);

    }

}
