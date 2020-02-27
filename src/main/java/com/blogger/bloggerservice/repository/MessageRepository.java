package com.blogger.bloggerservice.repository;

import com.blogger.bloggerservice.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author admin
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {

    /**
     * 通过收信人查询用户信息
     * @param userId
     * @param messageType
     * @return
     */
    List<Message> findByReceiverIdAndMessageType(Integer userId, Integer messageType);
}
