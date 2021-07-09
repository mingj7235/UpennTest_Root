package com.joshua.service.member;

import com.joshua.domain.members.Member;
import com.joshua.dto.MemberResponseDto;
import com.joshua.repository.members.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
//    public Optional<Member> member_detail (Long id) {
//        System.out.println("멤버 찾기");
//        return memberRepository.findById(id);
//    }
    public MemberResponseDto findById (Long id) {
        Member entity = memberRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("사용자없음 "));

        return new MemberResponseDto(entity);
    }

    @Transactional
    public Long update (Long id)

}
