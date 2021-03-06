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

    /**
     * 获取博客分类
     * @return
     */
    ResultVo getArticleType();

    /**
     * 获取博客详情
     * @param articleForm
     * @return
     */
    ResultVo getAriticleDetail(ArticleForm articleForm);

    /**
     * 获取关注人的博客
     * @param articleForm
     * @return
     */
    ResultVo getConcernBlog(ArticleForm articleForm);
}
