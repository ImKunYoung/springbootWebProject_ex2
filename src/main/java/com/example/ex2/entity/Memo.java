package com.example.ex2.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="tbl_memo")
@ToString
@Getter
@Builder // 객체 생성
@AllArgsConstructor // Builder 사용 시 컴파일 에러 방지
@NoArgsConstructor // Builder 사용 시 컴파일 에러 방지
public class Memo {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // default value IDENTITY
    private Long mno;

//    @Column(columnDefinition = "varchar(255) default 'yes'")
    @Column(length = 200, nullable = false)
    private String memoText;
}



