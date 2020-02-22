package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.bean.PageInfoBean;
import com.blogger.bloggerservice.constant.Constant;
import com.blogger.bloggerservice.constant.Param;
import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.form.ArticleForm;
import com.blogger.bloggerservice.model.Article;
import com.blogger.bloggerservice.model.User;
import com.blogger.bloggerservice.repository.ArticleReposity;
import com.blogger.bloggerservice.repository.ArticleTypeRepository;
import com.blogger.bloggerservice.repository.UserRepository;
import com.blogger.bloggerservice.repository.custom.ArticleReposityCustom;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author admin
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleReposity articleReposity;

    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    @Autowired
    private ArticleReposityCustom articleReposityCustom;

    @Autowired
    private UserRepository userRepository;

    /**
     * 上传博客文章
     * @param articleForm
     * @return
     */
    @Override
    public ResultVo uploadArticle(ArticleForm articleForm) {
        User user = userRepository.findByUserId(articleForm.getUserId());
        if (user == null) {
            return new ResultVo(ResponseEnums.ERROR_LOGIN_FAIL);
        }
        Article article = new Article();
        article.setArticleTitle(articleForm.getArticleTitle());
        article.setArticleContent(articleForm.getArticleContent());
        article.setArticleTypeId(articleForm.getArticleTypeId());
        article.setArticleInfo(articleForm.getArticleInfo());
        article.setArticleCount(articleForm.getArticleCount());
        article.setUserId(articleForm.getUserId());
        article.setArticleReplay(0);
        article.setUserName(user.getLoginName());
        article.setArticleLike(0);
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
        List<Map<String, Object>> articleList = articleReposityCustom.findArticleList(
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

    @Override
    public ResultVo getAriticleDetail(ArticleForm articleForm) {
        ResultVo resultVo = ResultVo.success();
        Map<String, Object> returnData = new HashMap<>();
        Article articleDetail = articleReposity.getArticleDetail(articleForm.getArticleId());
        returnData.put(Param.ARTICLE_DETAIL, articleDetail);
        returnData.put(Param.USER, userRepository.findByUserId(articleDetail.getUserId()));
        resultVo.setData(returnData);
        return resultVo;
    }
}
