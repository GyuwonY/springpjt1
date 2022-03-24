package com.sparta.srpingproject.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.PrePersist;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Board extends Timestamped
{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Long viewCnt;
    @Column(nullable = false)
    private String contents;

    @PrePersist
    public void prePersist() {
        this.viewCnt = ((this.viewCnt == null) ? 0L : this.viewCnt);
    }

    public Board(final BoardRequestDto requestDto) {
        this.name = requestDto.getName();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void viewCnt() {
        ++this.viewCnt;
    }
}