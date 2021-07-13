package com.joshua.service.member;

import com.joshua.domain.members.Location;
import com.joshua.domain.members.Member;
import com.joshua.dto.member.MemberResponseDto;
import com.joshua.dto.member.MemberSaveRequestDto;
import com.joshua.dto.member.MemberUpdateRequestDto;
import com.joshua.repository.members.LocationRepository;
import com.joshua.repository.members.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final LocationRepository locationRepository;

    @Transactional
    public MemberResponseDto findById (Long id) {
        Member entity = memberRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("사용자없음 "));
        return new MemberResponseDto(entity);
    }

    @Transactional
    public Long save (MemberSaveRequestDto requestDto) {
        Member entity = requestDto.toEntity();
        Optional<Location> location = locationRepository.findById(requestDto.getLocation_id());
        location.ifPresent(loc->{
            entity.setLocation(loc);
            loc.setLocation("chungjkhgffdu");
        });

        //Optional : get() : O ->
        //orElse ('세팅값') -> get을 하려는데, 값이 있으면 get과 같은 응답을주고, null인경우, '세팅값'을 리턴한다.
        //orElseGet('값을 생성하는 메서드가 들어간다. 값도 들어갈수있다.') -> 메모리절약.
        //orElseThrow(exception) : null일때 exception을 던짐
        return memberRepository.save(entity).getId();
    }

    @Transactional
    public Long update (Long id, MemberUpdateRequestDto requestDto) {

        Member member = memberRepository.findById(id).orElseThrow(
                 () -> new IllegalArgumentException("해당 사용자가 없습니다."));
        member.update(requestDto.getName(), requestDto.getPassword(), requestDto.getLocation());

        return id;
    }

}
