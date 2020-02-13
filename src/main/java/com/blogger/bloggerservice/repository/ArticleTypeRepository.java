package com.blogger.bloggerservice.repository;

import com.blogger.bloggerservice.model.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
public interface ArticleTypeRepository extends JpaRepository<ArticleType, Integer> {

    /**
     * 查询文章分类
     * @return
     */
    @Query(value = "select id,article_type_name 'name' from tb_article_type order by sort_order asc", nativeQuery = true)
    List<Map<String, Object>> getArticleType();
}
