package com.example.demo.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Page<Board> findAll(Pageable pageable);
    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    Page<Board> findByTitle(Pageable pageable, String title);
}
