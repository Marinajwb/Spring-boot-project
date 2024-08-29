package com.example.demo.dto;

import com.example.demo.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;


@ToString
@AllArgsConstructor
public class ArticleForm {


    private String title; //제목을 받을 필드
    private String content; //내용을 받을 필드
    private Long id;




    public Article toEntity() {

        return new Article(null,title,content);
    }
}
