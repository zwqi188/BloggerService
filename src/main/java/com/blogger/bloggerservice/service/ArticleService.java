package com.blogger.bloggerservice.service;

import com.blogger.bloggerservice.form.ArticleForm;
import com.blogger.bloggerservice.response.ResultVo;

/**
 * @author admin
 */
public interface ArticleService {

    /**
     * 上传博客接口
     * @param articleForm
     * @return
     */
    ResultVo uploadArticle(ArticleForm articleForm);

    /**
     * 获取博客列表信息（分页）
     * @param articleForm
     * @return
     */
    ResultVo getBlogList(ArticleForm articleForm);
}
