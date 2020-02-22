package com.blogger.bloggerservice.form;

import javax.validation.constraints.NotNull;

/**
 * @author admin
 */
public class ThumbsForm {

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空", groups = {ThumbsForm.ThumbsUp.class})
    private Integer userId;

    @NotNull(message = "文章id不能为空", groups = {ThumbsForm.ThumbsUp.class})
    private Integer articleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public interface ThumbsUp {
    }
}
