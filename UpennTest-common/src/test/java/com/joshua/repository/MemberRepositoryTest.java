package com.joshua.repository;

import com.joshua.domain.members.Member;
import com.joshua.domain.members.Role;
import com.joshua.repository.members.MemberRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @After
    public void cleanup () {
        memberRepository.deleteAll();
    }

    @Test
    public void 멤버등록확인 () {
        //given
        String name = "김민재";
        String email = "joshua@gmail.com";
        Role role = Role.GUEST;

        memberRepository.save(Member.builder().name(name).email(email).role(role).build());

        //when

        List<Member> memberList = memberRepository.findAll();

        //then
        Member member = memberList.get(0);
        assertThat(member.getName()).isEqualTo(name);
    }
}
