package com.blogger.bloggerservice.repository;

import com.blogger.bloggerservice.model.Article;
import com.blogger.bloggerservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author admin
 */
public interface ArticleReposity extends JpaRepository<Article, Integer> {

    /**
     * 查询文章列表
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Query(value = "select * from tb_article limit ?,?", nativeQuery = true)
    List<Article> getArticleList(Integer pageIndex, Integer pageSize);

    /**
     * 查询文章数量
     * @return
     */
    @Query(value = "select count(*) from tb_article", nativeQuery = true)
    Integer getArticleListCount();

    /**
     * 获取文章详情
     * @param articleId
     * @return
     */
    @Query(value = "select * from tb_article where id = ?", nativeQuery = true)
    Article getArticleDetail(Integer articleId);

    /**
     * 给文章点赞
     * @param articleId
     */
    @Modifying
    @Query("update Article a set a.articleLike = a.articleLike + 1 where a.id = ?1")
    void thumbsUpById(Integer articleId);
}
