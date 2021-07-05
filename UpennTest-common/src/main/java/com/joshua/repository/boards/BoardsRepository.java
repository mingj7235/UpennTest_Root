package com.joshua.repository.boards;

import com.joshua.domain.boards.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardsRepository extends JpaRepository<Board, Long> {

    @Query ("SELECT p FROM Board p ORDER BY p.id DESC")
    List<Board> findAllDesc();
}
