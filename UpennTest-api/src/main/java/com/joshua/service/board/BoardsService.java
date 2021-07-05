package com.joshua.service.board;

import com.joshua.repository.boards.BoardsRepository;
import com.joshua.springweb.awsspring.domain.posts.Posts;
import com.joshua.springweb.awsspring.domain.posts.PostsRepository;
import com.joshua.springweb.awsspring.web.dto.PostsListResponseDto;
import com.joshua.springweb.awsspring.web.dto.PostsResponseDto;
import com.joshua.springweb.awsspring.web.dto.PostsSaveRequestDto;
import com.joshua.springweb.awsspring.web.dto.PostsUpdateRequestDto;
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
    public Long save (PostsSaveRequestDto requestDto) {
        return boardsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update (Long id, PostsUpdateRequestDto requestDto) {

        Posts posts = boardsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없슴 id : "+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = boardsRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("해당 사용자가 없음 id :" + id));
        boardsRepository.delete(posts);
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = boardsRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("해당 사용자가 없습니다. id : " + id));

        return new PostsResponseDto(entity);
    }

    @Transactional (readOnly = true)
    public List<PostsListResponseDto> findAllDesc () {
        return boardsRepository.findAllDesc().stream()
                .map(PostsListResponseDto :: new)
                //.map(posts -> new PostsListResponseDto(posts))
                //postsRepository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsListResponseDto 변환 -> List로 반환하는 메소드
                .collect(Collectors.toList());
    }

    @Transactional
    public String totalNum () {
        return boardsRepository.totalNum();
    }

}
