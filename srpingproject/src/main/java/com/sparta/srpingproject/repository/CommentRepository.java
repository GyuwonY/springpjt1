package com.sparta.srpingproject.repository;


import com.sparta.srpingproject.model.Board;
import com.sparta.srpingproject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByboardId(Long boardId);
}
