package com.blogger.bloggerservice.service;

import com.blogger.bloggerservice.form.CommentForm;
import com.blogger.bloggerservice.form.WordForm;
import com.blogger.bloggerservice.response.ResultVo;

/**
 * @author admin
 */
public interface WordService {


    /**
     * 查询留言
     * @return
     */
    ResultVo queryWord();

    /**
     * 发表留言
     * @param form
     * @return
     */
    ResultVo publishWord(WordForm form);
}
