package com.sparta.srpingproject.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardRequestDto
{
    private String title;
    private String name;
    private String contents;
}