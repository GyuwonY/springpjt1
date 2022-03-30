package com.sparta.srpingproject.model;

import com.sparta.srpingproject.dto.CommentReqeustDto;
import com.sparta.srpingproject.utils.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@SequenceGenerator(
        name="COMMENT_SEQ", //시퀀스 제너레이터 이름
        sequenceName="COMMENT_SEQ_NO", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)
public class Comment extends Timestamped {
    @GeneratedValue(strategy=GenerationType.SEQUENCE,
            generator="COMMENT_SEQ")
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
