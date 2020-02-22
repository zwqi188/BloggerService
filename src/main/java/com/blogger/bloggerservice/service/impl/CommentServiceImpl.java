package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.form.CommentForm;
import com.blogger.bloggerservice.model.Article;
import com.blogger.bloggerservice.model.Comment;
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

    @Override
    public ResultVo getCommentByArticleId(CommentForm form) {
        ResultVo resultVo = ResultVo.success();
        resultVo.setData(commentReposityCustom.getCommentByArticleId(form.getArticleId()));
        return resultVo;
    }

    @Transactional
    @Override
    public ResultVo publishComment(CommentForm form) {
        Article articleDetail = articleReposity.getArticleDetail(form.getArticleId());
        articleDetail.setArticleReplay(articleDetail.getArticleReplay() + 1);
        articleReposity.save(articleDetail);
        Comment comment = new Comment();
        comment.setArticleId(form.getArticleId());
        comment.setReviewContent(form.getReviewContent());
        comment.setMasterId(form.getUserId());
        comment.setCreatedAt(new Date());
        comment.setUpdatedAt(new Date());
        commentReposity.save(comment);
        return ResultVo.success();
    }
}
