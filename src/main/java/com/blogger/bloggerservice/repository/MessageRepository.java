package com.blogger.bloggerservice.repository;

import com.blogger.bloggerservice.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

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

    /**
     * 查询该用户所有的消息
     * @param userId
     * @return
     */
    List<Message> findByReceiverId(Integer userId);

    /**
     * 通过用户id和信息类型更新为已读
     * @param userId
     * @param messageType
     */
    @Modifying
    @Query("update Message A set A.hasRead = 1 where A.receiverId = ?1 and A.messageType = ?2 ")
    void updateReadStaus(Integer userId, Integer messageType);
}
