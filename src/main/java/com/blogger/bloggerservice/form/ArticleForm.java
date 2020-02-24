package com.blogger.bloggerservice.form;

import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;

/**
 * @author admin
 */
public class ArticleForm {

    @NotNull(message = "博客分类不能为空", groups = {UploadArticle.class})
    private Integer articleTypeId;

    @NotNull(message = "博客标题不能为空", groups = {UploadArticle.class})
    private String articleTitle;

    @NotNull(message = "博客内容不能为空", groups = {UploadArticle.class})
    private String articleContent;

    @NotNull(message = "博客查询编号不能为空", groups = {AriticleDetail.class})
    private Integer articleId;

    @NotNull(message = "文章字数不能为空", groups = {UploadArticle.class})
    private Integer articleCount;

    @NotNull(message = "文章预览信息不能为空", groups = {UploadArticle.class})
    private String articleInfo;

    @NotNull(message = "用户id不能为空", groups = {Package.class, ConcernBlog.class})
    private Integer userId;

    /**
     * 页码大小
     */
    @NotNull(message = "页码大小不能为空", groups = {BlogList.class, ConcernBlog.class})
    private Integer pageSize;
    /**
     * 当前页
     */
    @NotNull(message = "当前页不能为空", groups = {BlogList.class, ConcernBlog.class})
    private Integer pageIndex;

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public String getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(String articleInfo) {
        this.articleInfo = articleInfo;
    }

    public interface UploadArticle {
    }

    public interface BlogList {
    }

    public interface AriticleDetail {
    }

    public interface Package {
    }

    public interface ConcernBlog {

    }
}
