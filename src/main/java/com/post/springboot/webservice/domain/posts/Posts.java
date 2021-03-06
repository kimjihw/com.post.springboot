package com.post.springboot.webservice.domain.posts;

import com.post.springboot.webservice.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@NoArgsConstructor// 기본생성자 자동 추가 public Posts(){}와 같은 효과
@Entity //테이블과 링크될 클래스임을 나타냄, 기본값으로 클래스으 ㅣ카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false) //굳이 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 됌
    // 사용하는 이유는 기본값 외에 추갈 ㅗ변경이 필요한 옵션이 있으면 사용,
    // 문자열의 경우 VARCHAR(255)가 기본값인데 사이즈를 500으로 늘리고 싶거나 타입을 TEXT로 변경하고 싶거나 등의 경우에 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
