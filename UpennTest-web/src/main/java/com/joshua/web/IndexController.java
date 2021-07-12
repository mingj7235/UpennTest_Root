package com.joshua.web;

import com.joshua.dto.BoardsResponseDto;
import com.joshua.service.boards.BoardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final BoardsService boardsService;


    @GetMapping("/")
    public String index (Model model) {

        model.addAttribute("boards", boardsService.findAllDesc());
        //test


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

    @GetMapping ("/member/mypage/{id}")
    public String mypage (@PathVariable Long id, Model model) {
        System.out.println("들어옴");



        return "member/member-mypage";
    }

}
