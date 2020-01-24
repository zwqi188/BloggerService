package com.blogger.bloggerservice.form;

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

    @NotNull(message = "用户id不能为空", groups = {UploadArticle.class})
    private Integer userId;

    /**
     * 页码大小
     */
    @NotNull(message = "页码大小不能为空", groups = {BlogList.class})
    private Integer pageSize;
    /**
     * 当前页
     */
    @NotNull(message = "当前页不能为空", groups = {BlogList.class})
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

    public interface UploadArticle {
    }

    public interface BlogList {
    }
}
