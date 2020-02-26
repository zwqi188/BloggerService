package com.blogger.bloggerservice.service;

import com.blogger.bloggerservice.exception.RespException;
import com.blogger.bloggerservice.form.UserForm;
import com.blogger.bloggerservice.response.ResultVo;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户相关service
 */
public interface UserService {

    /**
     * 新用户注册
     * @param userForm
     * @return
     */
    ResultVo register(UserForm userForm, HttpServletRequest request) throws RespException;

    /**
     * 用户登录
     * @param userForm
     * @return
     */
    ResultVo login(UserForm userForm, HttpServletRequest request) throws RespException;

    /**
     * 用户登出
     * @param userForm
     * @return
     */
    ResultVo loginOut(UserForm userForm, HttpServletRequest request) throws RespException;

    /**
     * 获得推荐作者
     * @return
     */
    ResultVo getRecommendUser(UserForm form);

    /**
     * 查询单个用户
     * @return
     */
    ResultVo queryUser(UserForm user);

    /**
     * 保存单个用户
     * @return
     */
    ResultVo saveUser(UserForm user);


    /**
     * 更新用户密码
     * @return
     */
    ResultVo updatePassword(UserForm form);
}
