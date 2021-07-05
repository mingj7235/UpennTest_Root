package com.joshua.service;

import com.joshua.domain.Member;
import com.joshua.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceCustom {

    //Root의 build.gradle에서 project로 dependencies 설정을 해줘야한다.
    private MemberRepository memberRepository;

    public MemberServiceCustom (MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long signup (Member member) {
        return memberRepository.save(member).getId();
    }
}
