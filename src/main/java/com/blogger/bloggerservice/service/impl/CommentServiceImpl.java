package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.constant.Constant;
import com.blogger.bloggerservice.enums.MessageTypeEnums;
import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.form.CommentForm;
import com.blogger.bloggerservice.model.Article;
import com.blogger.bloggerservice.model.Comment;
import com.blogger.bloggerservice.model.Message;
import com.blogger.bloggerservice.model.User;
import com.blogger.bloggerservice.repository.*;
import com.blogger.bloggerservice.repository.custom.CommentReposityCustom;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * @author admin
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentReposity commentReposity;

    @Autowired
    private CommentReposityCustom commentReposityCustom;

    @Autowired
    private ArticleReposity articleReposity;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public ResultVo getCommentByArticleId(CommentForm form) {
        ResultVo resultVo = ResultVo.success();
        resultVo.setData(commentReposityCustom.getCommentByArticleId(form.getArticleId()));
        return resultVo;
    }

    @Transactional
    @Override
    public ResultVo publishComment(CommentForm form) {
        User user = userRepository.findByUserId(form.getUserId());
        if (user == null) {
            return new ResultVo(ResponseEnums.ERROR_SEV_USER_NOT_LOGIN);
        }
        Article articleDetail = articleReposity.getArticleDetail(form.getArticleId());
        articleDetail.setArticleReplay(articleDetail.getArticleReplay() + 1);
        articleReposity.save(articleDetail);
        Comment comment = new Comment();
        comment.setArticleId(form.getArticleId());
        comment.setReviewContent(form.getReviewContent());
        comment.setMasterId(form.getUserId());
        comment.setCreatedAt(new Date());
        comment.setUpdatedAt(new Date());

        Message message = new Message();
        message.setSendId(user.getId());
        message.setSendName(user.getUserName());
        message.setMessageType(MessageTypeEnums.COMMENT.getCode());
        //TODO 添加收信人信息
//        message.setReceiverId("");
//        message.setReceiverName("");
        message.setMessageContent(form.getReviewContent());
        message.setHasRead(Constant.NOT_READ);
        message.setCreatedAt(new Date());
        commentReposity.save(comment);
        messageRepository.save(message);
        return ResultVo.success();
    }
}
