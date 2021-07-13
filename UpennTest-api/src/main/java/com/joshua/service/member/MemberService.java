package com.joshua.service.member;

import com.joshua.domain.members.Member;
import com.joshua.dto.member.MemberResponseDto;
import com.joshua.dto.member.MemberSaveRequestDto;
import com.joshua.dto.member.MemberUpdateRequestDto;
import com.joshua.repository.members.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto findById (Long id) {
        Member entity = memberRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("사용자없음 "));
        return new MemberResponseDto(entity);
    }

    @Transactional
    public Long save (MemberSaveRequestDto requestDto) {
        return memberRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update (Long id, MemberUpdateRequestDto requestDto) {

        Member member = memberRepository.findById(id).orElseThrow(
                 () -> new IllegalArgumentException("해당 사용자가 없습니다."));
        member.update(requestDto.getName(), requestDto.getPassword(), requestDto.getLocation());

        return id;
    }

}
