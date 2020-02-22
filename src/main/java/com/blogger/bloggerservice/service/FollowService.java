package com.blogger.bloggerservice.service;

import com.blogger.bloggerservice.form.FollowForm;
import com.blogger.bloggerservice.response.ResultVo;

/**
 * @author admin
 */
public interface FollowService {

    /**
     * 关注
     * @param form
     * @return
     */
    ResultVo follow(FollowForm form);

    /**
     * 取消关注
     * @param form
     * @return
     */
    ResultVo UnFollow(FollowForm form);

    /**
     * 查询我的关注列表
     * @param form
     * @return
     */
    ResultVo queryfollowByUserId(FollowForm form);
}
