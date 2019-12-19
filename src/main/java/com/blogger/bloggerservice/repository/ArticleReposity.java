package com.blogger.bloggerservice.repository;

import com.blogger.bloggerservice.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleReposity extends JpaRepository<Article, Integer> {
}
