package com.blogger.bloggerservice.service;

import com.blogger.bloggerservice.form.LoginForm;
import com.blogger.bloggerservice.response.ResultVo;

/**
 * @author admin
 */
public interface LoginService {

    /**
     * 登录
     * @param loginForm
     * @return
     */
    ResultVo login(LoginForm loginForm);

}
