package com.sparta.srpingproject.controller;

import com.sparta.srpingproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardRestController {
    private final BoardService boardService;

    @DeleteMapping({ "/board/{id}" })
    public Long delete(@PathVariable final Long id) {
        boardService.delete(id);
        return id;
    }
}
