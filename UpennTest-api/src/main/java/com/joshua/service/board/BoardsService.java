package com.joshua.service.board;

import com.joshua.domain.boards.Board;
import com.joshua.dto.BoardListResponseDto;
import com.joshua.dto.BoardResponseDto;
import com.joshua.dto.BoardSaveRequestDto;
import com.joshua.dto.BoardUpdateRequestDto;
import com.joshua.repository.boards.BoardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardsService {
    private final BoardsRepository boardsRepository;

    @Transactional
    public Long save (BoardSaveRequestDto requestDto) {
        return boardsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update (Long id, BoardUpdateRequestDto requestDto) {

        Board boards = boardsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없슴 id : "+id));
        boards.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Board board = boardsRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("해당 사용자가 없음 id :" + id));
        boardsRepository.delete(board);
    }

    public BoardResponseDto findById (Long id) {
        Board entity = boardsRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("해당 사용자가 없습니다. id : " + id));

        return new BoardResponseDto(entity);
    }

    @Transactional (readOnly = true)
    public List<BoardListResponseDto> findAllDesc () {
        return boardsRepository.findAllDesc().stream()
                .map(BoardListResponseDto :: new)
                .collect(Collectors.toList());
    }


}
