package com.sparta.srpingproject.controller;

import com.sparta.srpingproject.domain.BoardRequestDto;
import com.sparta.srpingproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class BoardController
{
    private final BoardService boardService;

    @GetMapping({ "/" })
    public String boardList(Model model) {
        model.addAttribute("boards", boardService.list());
        return "index";
    }

    @GetMapping({ "/board/form" })
    public String boardForm() {
        return "writeform";
    }

    @PostMapping({ "/board/form" })
    public String createBoard(BoardRequestDto requestDto) {
        this.boardService.createBoard(requestDto);
        return "redirect:/";
    }

    @GetMapping({ "/board/viewcnt/{id}" })
    public String viewCnt(@PathVariable Long id, RedirectAttributes redirect) {
        this.boardService.viewCnt(id);
        redirect.addAttribute("id", (Object)id);
        return "redirect:/board/detail";
    }

    @GetMapping({ "/board/detail" })
    public String detail(@RequestParam("id") Long id, Model model) {
        model.addAttribute("board", boardService.detail(id));
        model.addAttribute("newLine", '\n');
        return "detail";
    }

    @GetMapping({ "/board/delete/{id}" })
    public String delete(@PathVariable final Long id) {
        this.boardService.delete(id);
        return "redirect:/";
    }

}