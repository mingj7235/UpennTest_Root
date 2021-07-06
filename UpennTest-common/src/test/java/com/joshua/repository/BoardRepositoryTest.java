package com.joshua.repository;

import com.joshua.domain.boards.Boards;
import com.joshua.repository.boards.BoardsRepository;
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
public class BoardRepositoryTest {

    @Autowired
    BoardsRepository boardsRepository;

    @After
    public void clean () {
        boardsRepository.deleteAll();
    }

    @Test
    public void 게시글저장하기 () {
        //given
        String title = "테스트";
        String content = "테스트본문";
        String author = "테스트작성자";

        boardsRepository.save(Boards.builder().title(title).content(content).author(author).build());

        //when

        List<Boards> boardsList = boardsRepository.findAll();

        //then

        Boards testBoard = boardsList.get(0);

        assertThat(testBoard.getTitle()).isEqualTo(title);

    }

}
