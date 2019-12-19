package com.blogger.bloggerservice.form;

import javax.validation.constraints.NotNull;

/**
 * @author admin
 */
public class ArticleForm {

    @NotNull(message = "博客内容不能为空", groups = {uploadArticle.class})
    private String articleContent;

    @NotNull(message = "博客分类不能为空", groups = {uploadArticle.class})
    private Integer articleType;

    @NotNull(message = "博客标题不能为空", groups = {uploadArticle.class})
    private String articleTitle;

    private Integer masterId;

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Integer getArticleType() {
        return articleType;
    }

    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public interface uploadArticle {}
}
