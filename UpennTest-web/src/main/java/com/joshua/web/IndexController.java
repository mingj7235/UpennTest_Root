package com.joshua.web;

import com.joshua.domain.members.Member;
import com.joshua.dto.boards.BoardsResponseDto;
import com.joshua.service.boards.BoardsService;
import com.joshua.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final BoardsService boardsService;
    private final MemberService memberService;


    @RequestMapping (value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String index (Member member, HttpServletRequest req, RedirectAttributes rttr, Model model) throws Exception {

        HttpSession session = req.getSession();

        model.addAttribute("boards", boardsService.findAllDesc());
        return "index";
    }

    @GetMapping("/boards/save")
    public String save (Model model) {
        System.out.println(">>>>>>>>>>>>>>>>들어옴");
        //System.out.println("user의 로케이션 : " + user.getLocation().getLocation());

        //update문이 들어가는지 확인 (save 페이지 들어갈 시) -> default 값 확인
       // user.setLocation(new Location(1L, "SEOUL"));
        //System.out.println("user locaiton : " + user.getLocation().getLocation());
        return "boards/boards-save";
    }

    @GetMapping ("/boards/detail/{id}")
    public String detail (@PathVariable Long id, Model model) {
        BoardsResponseDto dto = boardsService.findById(id);
        model.addAttribute("boards",dto);
        return "boards/boards-detail";

    }

    @GetMapping ("/boards/update/{id}")
    public String update (@PathVariable Long id, Model model) {
        BoardsResponseDto dto = boardsService.findById(id);
        model.addAttribute("boards", dto);
        return "boards/boards-update";
    }

    @GetMapping ("/member/join")
    public String join () {
        return "member/join";
    }



    @GetMapping ("/member/mypage/{id}")
    public String mypage (@PathVariable Long id, Model model) {
        System.out.println("들어옴");

        return "member/member-mypage";
    }

}
