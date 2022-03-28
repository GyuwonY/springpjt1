package com.sparta.srpingproject.controller;

import com.sparta.srpingproject.dto.CommentReqeustDto;
import com.sparta.srpingproject.model.Comment;
import com.sparta.srpingproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/comment")
    public List<Comment> commentList(@RequestParam Long boardId){
        return commentService.list(boardId);
    }

    @PostMapping("/comment")
    public void registComment(@RequestBody CommentReqeustDto commentReqeustDto){
        commentService.registComment(commentReqeustDto);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }

    @PutMapping("/comment")
    public void updateComment(@RequestBody CommentReqeustDto commentReqeustDto){
        commentService.updateComment(commentReqeustDto);
    }
}
