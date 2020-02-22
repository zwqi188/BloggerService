package com.blogger.bloggerservice.repository;

import com.blogger.bloggerservice.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author admin
 */

@Repository
public interface WordReposity extends JpaRepository<Word, Integer> {

}
