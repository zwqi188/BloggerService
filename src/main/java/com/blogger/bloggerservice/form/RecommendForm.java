package com.blogger.bloggerservice.form;

import javax.validation.constraints.NotNull;

/**
 * @author admin
 */
public class RecommendForm extends BaseForm {

    @NotNull(message = "推荐用户索引不能为空", groups = {GetRecommendUser.class})
    private Integer index;

    public RecommendForm() {
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }


    public interface GetRecommendUser {
    }
}
