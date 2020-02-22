package com.blogger.bloggerservice.form;

import javax.validation.constraints.NotNull;

/**
 * @author admin
 */
public class CommentForm {


    @NotNull(message = "文章id不能为空", groups = {CommentForm.Comment.class, CommentForm.PubishComment.class})
    private Integer articleId;

    @NotNull(message = "评论内容不能为空", groups = {CommentForm.PubishComment.class})
    private String reviewContent;

    @NotNull(message = "评论人不能为空", groups = {CommentForm.PubishComment.class})
    private Integer userId;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public interface Comment {
    }

    public interface PubishComment {
    }
}
