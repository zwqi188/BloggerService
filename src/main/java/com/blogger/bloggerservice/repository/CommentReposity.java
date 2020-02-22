package com.blogger.bloggerservice.repository;

import com.blogger.bloggerservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author admin
 */

@Repository
public interface CommentReposity extends JpaRepository<Comment, Integer> {

}
