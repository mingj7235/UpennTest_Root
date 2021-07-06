package com.joshua.repository.boards;

import com.joshua.domain.boards.Boards;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardsRepositoryTest {

    BoardsRepository boardsRepository;

    @After
    public void clean () {
        boardsRepository.deleteAll();
    }

    @Test
    public void 게시판저장테스트 () {
        //given
        String title = "테스트타이틀";
        String content = "테스트컨텐트";
        String author = "테스트글쓴이";

        boardsRepository.save(Boards.builder().title(title).content(content).author(author).build());

        //when

        List<Boards> boardsList = boardsRepository.findAll();

        //then

        Boards testBoard = boardsList.get(0);
        assertThat(testBoard.getTitle()).isEqualTo(title);

    }

}
