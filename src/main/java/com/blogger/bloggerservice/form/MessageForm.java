package com.blogger.bloggerservice.form;

import javax.validation.constraints.NotNull;

/**
 * @author admin
 */
public class MessageForm {

    @NotNull(message = "用户id不能为空", groups = {QueryMessage.class})
    private Integer userId;

    @NotNull(message = "消息类型不能为空", groups = {QueryMessage.class})
    private Integer messageType;

    @NotNull(message = "消息id不能为空", groups = {DeleteMessage.class})
    private Integer id;

    public MessageForm() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public interface QueryMessage {
    }

    public interface DeleteMessage {
    }
}
