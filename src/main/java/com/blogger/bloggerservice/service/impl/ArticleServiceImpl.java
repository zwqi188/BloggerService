package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.bean.PageInfoBean;
import com.blogger.bloggerservice.constant.Param;
import com.blogger.bloggerservice.form.ArticleForm;
import com.blogger.bloggerservice.model.Article;
import com.blogger.bloggerservice.repository.ArticleReposity;
import com.blogger.bloggerservice.repository.ArticleTypeRepository;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleReposity articleReposity;

    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    /**
     * 上传博客文章
     * @param articleForm
     * @return
     */
    @Override
    public ResultVo uploadArticle(ArticleForm articleForm) {
        Article article = new Article();
        article.setArticleTitle(articleForm.getArticleTitle());
        article.setArticleContent(articleForm.getArticleContent());
        article.setArticleTypeId(articleForm.getArticleTypeId());
        article.setUserId(articleForm.getUserId());
        article.setUpdatedAt(new Date());
        article.setCreatedAt(new Date());
        Article save = articleReposity.save(article);
        if(save != null) {
            return ResultVo.success();
        }
        return ResultVo.fail();
    }

    /**
     * 获取博客列表信息（分页）
     * @param articleForm
     * @return
     */
    @Override
    public ResultVo getBlogList(ArticleForm articleForm) {
        PageInfoBean pageInfoBean = new PageInfoBean(articleForm.getPageIndex(), articleForm.getPageSize());
        List<Article> articleList = articleReposity.getArticleList(
                pageInfoBean.getCurrentPage(), pageInfoBean.getPageSize());
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put(Param.BLOG_LIST, articleList);
        returnMap.put(Param.COUNT, articleReposity.getArticleListCount());
        returnMap.put(Param.CURRENT_PAGE, articleForm.getPageIndex());
        ResultVo resultVo = ResultVo.success();
        resultVo.setData(returnMap);
        return resultVo;
    }

    /**
     * 获取博客分类
     * @return
     */
    @Override
    public ResultVo getArticleType() {
        ResultVo resultVo = ResultVo.success();
        resultVo.setData(articleTypeRepository.getArticleType());
        return resultVo;
    }
}
