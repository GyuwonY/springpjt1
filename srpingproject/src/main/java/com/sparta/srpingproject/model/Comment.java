package com.sparta.srpingproject.model;

import com.sparta.srpingproject.dto.CommentReqeustDto;
import com.sparta.srpingproject.utils.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Long boardId;

    public Comment(CommentReqeustDto commentReqeustDto){
        this.username = commentReqeustDto.getUsername();
        this.comment = commentReqeustDto.getComment();
        this.boardId = commentReqeustDto.getBoardId();
    }

    public void update(String comment){
        this.comment = comment;
    }
}
