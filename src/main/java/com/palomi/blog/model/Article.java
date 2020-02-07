package com.palomi.blog.model;

import javax.persistence.*;

@Entity
@Table(name="articles")
public class Article extends Model {
    @Id
    @GeneratedValue(generator = "article_generator")
    @SequenceGenerator(
            name="article_generator",
            sequenceName = "article_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(columnDefinition = "text")
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
