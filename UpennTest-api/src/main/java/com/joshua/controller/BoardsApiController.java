package com.joshua.controller;

import com.joshua.dto.boards.BoardsSaveRequestDto;
import com.joshua.dto.boards.BoardsUpdateRequestDto;
import com.joshua.service.boards.BoardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardsApiController {

    private final BoardsService boardsService;

    @PostMapping("/api/boards")
    public Long save (@RequestBody BoardsSaveRequestDto requestDto) {
        return boardsService.save(requestDto);
    }

    @PutMapping("/api/boards/{id}")
    public Long update (@PathVariable Long id, @RequestBody BoardsUpdateRequestDto requestDto) {
        System.out.println("수정 확인/ 수정된 제목 : " + requestDto.getTitle());
        System.out.println("수정 확인/ 수정된 내용 : " + requestDto.getContent());
        return boardsService.update(id, requestDto);
    }

    @DeleteMapping ("/api/boards/{id}")
    public Long delete (@PathVariable Long id) {
        boardsService.delete(id);
        System.out.println(id + "번째 글 삭제 완료");
        return id;
    }





}
