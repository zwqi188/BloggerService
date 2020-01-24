package com.blogger.bloggerservice.repository;

import com.blogger.bloggerservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<User, Integer> {
}
