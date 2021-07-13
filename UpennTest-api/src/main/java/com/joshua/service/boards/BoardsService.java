package com.joshua.service.boards;

import com.joshua.domain.boards.Boards;
import com.joshua.dto.boards.BoardsListResponseDto;
import com.joshua.dto.boards.BoardsResponseDto;
import com.joshua.dto.boards.BoardsSaveRequestDto;
import com.joshua.dto.boards.BoardsUpdateRequestDto;
import com.joshua.repository.boards.BoardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardsService {
    private final BoardsRepository boardsRepository;

    @Transactional
    public Long save (BoardsSaveRequestDto requestDto) {
        return boardsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update (Long id, BoardsUpdateRequestDto requestDto) {

        Boards boards = boardsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없슴 id : "+id));
        boards.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Boards boards = boardsRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("해당 사용자가 없음 id :" + id));
        boardsRepository.delete(boards);
    }

    public BoardsResponseDto findById (Long id) {
        Boards entity = boardsRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("해당 사용자가 없습니다. id : " + id));

        return new BoardsResponseDto(entity);
    }

    //findAll을 DESC로 바꾸는 방법
    @Transactional (readOnly = true)
    public List<BoardsListResponseDto> findAllDesc () {
        return boardsRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream()
                .map(BoardsListResponseDto:: new)
                .collect(Collectors.toList());
    }


}
