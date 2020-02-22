package com.blogger.bloggerservice.form;

import javax.validation.constraints.NotNull;

/**
 * @author admin
 */
public class WordForm {

    @NotNull(message = "留言内容不能为空", groups = {WordForm.PubishWord.class})
    private String wordContent;

    @NotNull(message = "评论人不能为空", groups = {WordForm.PubishWord.class})
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWordContent() {
        return wordContent;
    }

    public void setWordContent(String wordContent) {
        this.wordContent = wordContent;
    }

    public interface PubishWord {
    }
}
