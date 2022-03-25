package com.sparta.srpingproject.service;

import javax.transaction.Transactional;
import com.sparta.srpingproject.model.Board;
import com.sparta.srpingproject.repository.BoardRepository;
import com.sparta.srpingproject.dto.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService
{
    private final BoardRepository boardRepository;

    @Transactional
    public List<Board> list() {
        return boardRepository.findAllByOrderByIdDesc();
    }

    @Transactional
    public void createBoard(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
    }

    @Transactional
    public void viewCnt(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        board.viewCnt();
    }

    @Transactional
    public Board detail(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        return board;
    }

    @Transactional
    public void delete(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        boardRepository.deleteById(id);
    }

}