package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.form.MessageForm;
import com.blogger.bloggerservice.repository.ArticleTypeRepository;
import com.blogger.bloggerservice.repository.MessageRepository;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.MessageService;
import com.blogger.bloggerservice.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public ResultVo queryMessage(MessageForm form) {
        ResultVo resultVo = ResultVo.success();
        resultVo.setData(messageRepository.findByReceiverIdAndMessageType(
                form.getUserId(), form.getMessageType()));
        return resultVo;
    }

    @Override
    public ResultVo deleteMessage(MessageForm form) {
        try {
            messageRepository.deleteById(form.getId());
        } catch (Exception e) {
            return new ResultVo(ResponseEnums.ERROR_SAVE_TO_DATEBASE);
        }
        return ResultVo.success();
    }
}
