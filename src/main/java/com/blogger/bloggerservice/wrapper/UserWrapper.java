package com.blogger.bloggerservice.wrapper;

import com.blogger.bloggerservice.exception.RespException;
import com.blogger.bloggerservice.model.User;

/**
 * 用户信息wrapper
 */
public interface UserWrapper {

    /**
     * 获取用户信息
     * @param loginName
     * @param userPassword
     * @return
     */
    User getUserInfo(String loginName, String userPassword) throws RespException;

    /**
     * 获取用户信息
     * @param loginName
     * @return
     */
    User getUserInfo(String loginName) throws RespException;

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    User getUserInfo(Integer userId) throws RespException;
}
