package com.joshua.member;

import com.joshua.domain.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @GetMapping("/")
    public Member get () {
        return new Member("joshua", "joshua@email.com");
    }

}
