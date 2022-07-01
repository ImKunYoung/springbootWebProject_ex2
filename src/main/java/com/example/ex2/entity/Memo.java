package com.example.ex2.entity;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="tbl_memo")
@ToString
public class Memo {


    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // default value IDENTITY
    private Long mno;

}
