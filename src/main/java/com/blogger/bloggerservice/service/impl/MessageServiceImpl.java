package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.constant.Constant;
import com.blogger.bloggerservice.constant.Param;
import com.blogger.bloggerservice.enums.MessageTypeEnums;
import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.form.MessageForm;
import com.blogger.bloggerservice.model.Message;
import com.blogger.bloggerservice.repository.ArticleTypeRepository;
import com.blogger.bloggerservice.repository.MessageRepository;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.MessageService;
import com.blogger.bloggerservice.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public ResultVo getMessageCount(MessageForm form) {
        ResultVo resultVo = ResultVo.success();
        Integer comment = 0;
        Integer follow = 0;
        Integer thumbs = 0;
        Integer other = 0;
        List<Message> messageList = messageRepository.findByReceiverId(form.getUserId());
        for (Message message: messageList) {
            if (message.getHasRead().equals(Constant.READ)) {
                continue;
            }
            if (MessageTypeEnums.COMMENT.getCode().equals(message.getMessageType())) {
                comment ++ ;
            }
            if (MessageTypeEnums.FOLLOW.getCode().equals(message.getMessageType())) {
                follow ++ ;
            }
            if (MessageTypeEnums.THUMBS.getCode().equals(message.getMessageType())) {
                thumbs ++ ;
            }
            if (MessageTypeEnums.OTHER.getCode().equals(message.getMessageType())) {
                other ++ ;
            }
        }
        Map<String, Integer> returnMap = new HashMap<>();
        if (!comment.equals(0)) {
            returnMap.put(Param.COMMENT, comment);
        }
        if (!follow.equals(0)) {
            returnMap.put(Param.FOLLOW, follow);
        }
        if (!thumbs.equals(0)) {
            returnMap.put(Param.THUMBS, thumbs);
        }
        if (!other.equals(0)) {
            returnMap.put(Param.OTHER, other);
        }
        resultVo.setData(returnMap);
        return resultVo;
    }

    @Transactional
    @Override
    public ResultVo updateReadStatus(MessageForm form) {
        try {
            messageRepository.updateReadStaus(form.getUserId(), form.getMessageType());
        } catch (Exception e) {
            return new ResultVo(ResponseEnums.ERROR_SAVE_TO_DATEBASE);
        }
        return ResultVo.success();
    }
}
