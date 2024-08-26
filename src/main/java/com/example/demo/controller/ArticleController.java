package com.example.demo.controller;


import com.example.demo.dto.ArticleForm;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
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
//        System.out.println("article.toString");
        //2. 리파지토리로 엔티티를 DB에 저장

        Article saved = (Article)articleRepository.save(article);
//        System.out.println(saved.toString());
        log.info(form.toString());
        return "redirect:/articles/"+ saved.getId();
    }


    @GetMapping("/articles/{id}")
    public String show (@PathVariable Long id, Model model){

        log.info("id =" +id);

        //1.id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //2. 모델에 데이터 등록하기
        model.addAttribute("article",articleEntity);
        //3. 뷰 페이지 전달받기
        return "articles/show";

    }
    @GetMapping("/articles")
    public String index( Model model){

        //1.모든 데이터 가져오기
        // 다운캐스팅
        //  List<Article> articleEntityList = (List<Article>) articleRepository.findAll();

        List<Article> articleEntityList = articleRepository.findAll();
        model.addAttribute("articleList",articleEntityList);



                //캐스팅 - ?
                // 데이터 형변환
        //2.모델에 데이터 등록하기
        //3. 뷰 페이지 설정하기


        return"articles/index";
    }
    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        //수정 할 데이터 레파지토리에서 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article",articleEntity);
        return "articles/edit";
    }

}
