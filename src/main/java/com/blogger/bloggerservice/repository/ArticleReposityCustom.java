package com.blogger.bloggerservice.repository;

import com.blogger.bloggerservice.model.Article;

import java.util.List;

public interface ArticleReposityCustom {
    List<Article> findArticlePage();
}
