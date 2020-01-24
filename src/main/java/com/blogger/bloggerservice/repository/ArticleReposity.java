package com.blogger.bloggerservice.repository;

import com.blogger.bloggerservice.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleReposity extends JpaRepository<Article, Integer> {

    @Query(value = "select * from tb_article limit ?,?", nativeQuery = true)
    List<Article> getArticleList(Integer pageIndex, Integer pageSize);

    @Query(value = "select count(*) from tb_article", nativeQuery = true)
    Integer getArticleListCount();
}
