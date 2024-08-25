package com.example.demo.controller;


import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Slf4j
@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("articles/new")
    public String newArticleForm() {

        return "articles/new";
    }
    @PostMapping("articles/create")
    public String createArticle(ArticleForm form) {

        log.info(form.toString());
//        System.out.println(form.toString());
        //1.DTO를 엔터티로 변환


        Article article = form.toEntity();
        System.out.println("article.toString");
        //2. 리파지토리로 엔티티를 DB에 저장

        Article saved = (Article)articleRepository.save(article);
//        System.out.println(saved.toString());
        log.info(form.toString());
        return "articles/new";
    }


    @GetMapping("/articles/{id}")
    public String show (@PathVariable Long id){

        log.info("id =" +id);

        //1.id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //2. 모델에 데이터 등록하기
        //3. 뷰 페이지 전달받기
        return "";

    }

}
