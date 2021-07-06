package com.joshua.controller;

import com.joshua.dto.BoardsSaveRequestDto;
import com.joshua.service.boards.BoardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardsApiController {

    private final BoardsService boardsService;

    @PostMapping("/api/boards")
    public Long save (@RequestBody BoardsSaveRequestDto requestDto) {
        return boardsService.save(requestDto);
    }


}
