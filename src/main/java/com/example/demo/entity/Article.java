package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
@Getter
public class  Article {
    @Id //엔티티의 대푯값 지정
    @GeneratedValue //자동생성 기능 추가
    private Long id;
    @Column
    private String title;
    @Column
    private String content;



}



