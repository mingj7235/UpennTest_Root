package com.joshua.repository.boards;

import com.joshua.domain.boards.Boards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardsRepository extends JpaRepository<Boards, Long> {

    @Query ("SELECT p FROM Board p ORDER BY p.id DESC")
    List<Boards> findAllDesc();
}
