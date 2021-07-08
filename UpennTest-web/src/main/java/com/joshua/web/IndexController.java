package com.joshua.web;

import com.joshua.config.auth.LoginUser;
import com.joshua.config.auth.dto.SessionUser;
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
    public String index (Model model, @LoginUser SessionUser user) {

        model.addAttribute("boards", boardsService.findAllDesc());

        if (user != null) {
            model.addAttribute("memberName", user.getName());
        }

        return "index";
    }

    @GetMapping("/boards/save")
    public String save (Model model) {
        System.out.println(">>>>>>>>>>>>>>>>들어옴");
        return "boards-save";
    }

    @GetMapping ("/boards/detail/{id}")
    public String detail (@PathVariable Long id, Model model) {
        BoardsResponseDto dto = boardsService.findById(id);
        model.addAttribute("boards",dto);
        return "boards-detail";

    }

    @GetMapping ("/boards/update/{id}")
    public String update (@PathVariable Long id, Model model) {
        BoardsResponseDto dto = boardsService.findById(id);
        model.addAttribute("boards", dto);
        return "boards-update";
    }


}