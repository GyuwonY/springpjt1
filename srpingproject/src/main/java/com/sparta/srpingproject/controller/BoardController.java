package com.sparta.srpingproject.controller;

import com.sparta.srpingproject.dto.BoardRequestDto;
import com.sparta.srpingproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    public String boardList(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("boards", boardService.list());
        if(userDetails != null){
            model.addAttribute("username", userDetails.getUsername());
        }

        return "index";
    }

    @GetMapping({ "/board/form" })
    public String boardForm(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        return "writeform";
    }

    @PostMapping({ "/board/form" })
    public String createBoard(BoardRequestDto requestDto) {
        boardService.createBoard(requestDto);
        return "redirect:/";
    }

    @GetMapping({ "/board/viewcnt/{id}" })
    public String viewCnt(@PathVariable Long id, RedirectAttributes redirect) {
        boardService.viewCnt(id);
        return "redirect:/board/detail/"+id;
    }

    @GetMapping({ "/board/detail/{id}" })
    public String detail(@PathVariable Long id, Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("board", boardService.detail(id));
        model.addAttribute("newLine", '\n');
        if(userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
        }
        return "detail";
    }

    @DeleteMapping({ "/board/{id}" })
    public String delete(@PathVariable final Long id) {
        boardService.delete(id);
        return "redirect:/";
    }

}