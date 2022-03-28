package com.sparta.srpingproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentReqeustDto {
    private Long id;
    private String username;
    private String comment;
    private Long boardId;

}
