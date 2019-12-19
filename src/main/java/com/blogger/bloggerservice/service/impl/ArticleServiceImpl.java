package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.form.ArticleForm;
import com.blogger.bloggerservice.model.Article;
import com.blogger.bloggerservice.repository.ArticleReposity;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author admin
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleReposity articleReposity;

    @Override
    public ResultVo uploadArticle(ArticleForm articleForm) {
        Article article = new Article();
        article.setArticleTitle(articleForm.getArticleTitle());
        article.setArticleContent(articleForm.getArticleContent());
        article.setArticleTypeId(articleForm.getArticleType());
        article.setMasterId(articleForm.getMasterId());
        article.setUpdatedAt(new Date());
        article.setCreatedAt(new Date());
        Article save = articleReposity.save(article);
        if(save != null) {
            return ResultVo.success();
        }
        return ResultVo.fail();
    }
}
