package com.palomi.blog.controller;

import com.palomi.blog.model.Article;
import com.palomi.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles")
    public Page<Article> getArticles(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @PostMapping("/articles")
    public Article createArticle(@Valid @RequestBody Article article) {
        return articleRepository.save(article);
    }

}
