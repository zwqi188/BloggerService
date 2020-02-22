package com.blogger.bloggerservice.form;

import javax.validation.constraints.NotNull;

/**
 * @author admin
 */
public class FollowForm {

    @NotNull(message = "用户编号不能为空", groups = {Follow.class, UnFollow.class, QueryFollow.class})
    private Integer userId;

    @NotNull(message = "关注不能为空", groups = {Follow.class, UnFollow.class})
    private Integer followId;

    public FollowForm() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public interface Follow {
    }

    public interface UnFollow {
    }

    public interface QueryFollow {
    }
}
