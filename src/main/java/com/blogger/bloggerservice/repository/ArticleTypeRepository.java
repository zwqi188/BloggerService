package com.blogger.bloggerservice.repository;

import com.blogger.bloggerservice.model.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author admin
 */
public interface ArticleTypeRepository extends JpaRepository<ArticleType, Integer> {
}
