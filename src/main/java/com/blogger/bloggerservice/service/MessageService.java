package com.blogger.bloggerservice.service;

import com.blogger.bloggerservice.form.MessageForm;
import com.blogger.bloggerservice.response.ResultVo;

/**
 * @author admin
 */
public interface MessageService {

    /**
     * 通过用户id查询用户信息
     * @param form
     * @return
     */
    ResultVo queryMessage(MessageForm form);

    /**
     * 通过id查询删除消息
     * @param form
     * @return
     */
    ResultVo deleteMessage(MessageForm form);
}
