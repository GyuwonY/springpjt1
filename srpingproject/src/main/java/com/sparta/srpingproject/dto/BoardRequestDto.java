package com.sparta.srpingproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardRequestDto {
    private String title;
    private String name;
    private String contents;
}