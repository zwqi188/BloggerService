package com.blogger.bloggerservice.service;

import com.blogger.bloggerservice.form.ThumbsForm;
import com.blogger.bloggerservice.response.ResultVo;

/**
 * @author admin
 */
public interface ThumbsService {

    /**
     * 点赞
     * @return
     */
    ResultVo thumbsUp(ThumbsForm thumbs);
}
