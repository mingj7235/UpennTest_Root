package com.joshua.repository.boards;

import com.joshua.domain.boards.Boards;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@SpringBootConfiguration
public class BoardsRepositoryTest {

    @Autowired
    BoardsRepository boardsRepository;

    @AfterEach
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
