package com.palomi.blog.controller;

import com.palomi.blog.exception.ResourceNotFoundException;
import com.palomi.blog.model.Article;
import com.palomi.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
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

    @PutMapping("/articles/{articleId}")
    public Article updateArticle(@PathVariable Long articleId,
                                 @Valid @RequestBody Article articleRequest) {
        return articleRepository.findById(articleId)
                .map(article -> {
                    article.setText(articleRequest.getText());
                    return articleRepository.save(article);
                }).orElseThrow(() -> new ResourceNotFoundException("Article not found with id " + articleId + "!"));
    }

    @DeleteMapping("/articles/{articleId}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long articleId) {
        return articleRepository.findById(articleId)
                .map(article -> {
                    articleRepository.delete(article);
//                    return ResponseEntity.ok().build();
                    return ResponseEntity.ok("Article with id " + articleId + " was successfully deleted!");
                }).orElseThrow(() -> new ResourceNotFoundException("Article not found with id " + articleId + "!"));
    }

}
