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
    public Comment registComment(@RequestBody CommentReqeustDto commentReqeustDto){
        return commentService.registComment(commentReqeustDto);
    }

    @GetMapping("/comment/{id}")
    public Comment commentFindById(@PathVariable Long id){
        return commentService.commentFindById(id);
    }

    @DeleteMapping("/comment/{id}")
    public Long deleteComment(@PathVariable Long id){
        return commentService.deleteComment(id);
    }

    @PutMapping("/comment/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentReqeustDto commentReqeustDto){
        System.out.println(commentReqeustDto);
        commentService.updateComment(id, commentReqeustDto);
        return commentReqeustDto.getId();
    }
}
