package com.sparta.srpingproject.model;

import com.sparta.srpingproject.utils.Timestamped;
import com.sparta.srpingproject.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@SequenceGenerator(
        name="BOARD_SEQ", //시퀀스 제너레이터 이름
        sequenceName="BOARD_SEQ_NO", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)
public class Board extends Timestamped
{
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="BOARD_SEQ")
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