package com.sparta.srpingproject.service;

import com.sparta.srpingproject.dto.CommentReqeustDto;
import com.sparta.srpingproject.model.Comment;
import com.sparta.srpingproject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public List<Comment> list(Long boardId) {
        return commentRepository.findAllByboardId(boardId);
    }

    @Transactional
    public void registComment(CommentReqeustDto commentRequestDto){
        Comment comment = new Comment(commentRequestDto);
        commentRepository.save(comment);
    }

    @Transactional
    public void updateComment(CommentReqeustDto commentReqeustDto){
        Comment comment = commentRepository.findById(commentReqeustDto.getId()).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        comment.update(commentReqeustDto.getComment());
    }

    @Transactional
    public void deleteComment(Long id){
        commentRepository.deleteById(id);
    }
}
