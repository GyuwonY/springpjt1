package com.sparta.srpingproject.repository;

import java.util.List;

import com.sparta.srpingproject.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>
{
    List<Board> findAllByOrderByIdDesc();
}