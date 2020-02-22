package com.blogger.bloggerservice.service;

import com.blogger.bloggerservice.form.CommentForm;
import com.blogger.bloggerservice.response.ResultVo;

/**
 * @author admin
 */
public interface CommentService {

    /**
     * 查询评论信息
     * @param form
     * @return
     */
    ResultVo getCommentByArticleId(CommentForm form);

    /**
     * 发表评论信息
     * @param form
     * @return
     */
    ResultVo publishComment(CommentForm form);
}
