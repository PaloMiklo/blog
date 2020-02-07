package com.palomi.blog.controller;

import com.palomi.blog.model.Article;
import com.palomi.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping("/articles")
    public Article createArticle(@Valid @RequestBody Article article){
        return articleRepository.save(article);
    }

}
