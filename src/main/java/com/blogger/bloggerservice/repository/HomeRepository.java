package com.blogger.bloggerservice.repository;

import com.blogger.bloggerservice.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Master, Integer> {
}
