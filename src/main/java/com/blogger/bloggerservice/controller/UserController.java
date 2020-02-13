package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.exception.RespException;
import com.blogger.bloggerservice.form.UserForm;
import com.blogger.bloggerservice.service.UserService;
import com.blogger.bloggerservice.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author admin
 */
@Controller
@Validated
@RequestMapping(value = "/sys")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * 接口名 /sys/register.json
     * 入参
     * userName           String|M|用户名
     * userPassword       String|M|用户密码
     * varifyCode         String|M|验证码
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     * <p>
     * 示例
     *
     * @return
     */
    @RequestMapping(value = "/register.json", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody @Validated(value = UserForm.Register.class) UserForm login,
                           HttpServletRequest request) throws RespException {
        return JsonUtils.objectToString(userService.register(login, request));
    }

    /**
     * 用户登录
     * 接口名 /sys/login.json
     * 入参
     * userName           String|M|用户名
     * userPassword       String|M|用户密码
     * varifyCode         String|M|验证码
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * <p>
     * 示例
     *
     * @return
     */
    @RequestMapping(value = "/login.json", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody @Validated(value = UserForm.Login.class) UserForm login,
                        HttpServletRequest request) throws RespException {
        return JsonUtils.objectToString(userService.login(login, request));
    }


    /**
     * 用户登出
     * 接口名 /sys/login.json
     * 入参
     * userName           String|M|用户名
     * userPassword       String|M|用户密码
     * varifyCode         String|M|验证码
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * <p>
     * 示例
     *
     * @return
     */
    @RequestMapping(value = "/loginOut.json", method = RequestMethod.POST)
    @ResponseBody
    public String loginOut(@RequestBody @Validated(value = UserForm.LoginOut.class) UserForm login,
                           HttpServletRequest request) throws RespException {
        return JsonUtils.objectToString(userService.loginOut(login, request));
    }


    /**
     * 获取博客类型
     * 接口名 /sys/getRecommendUser.json
     * 入参
     * 无
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     * <p>
     * 示例
     *
     * @return
     */
    @RequestMapping(value = "/getRecommendUser.json", method = RequestMethod.POST)
    @ResponseBody
    public String getRecommendUser(UserForm user) {
        return JsonUtils.objectToString(userService.getRecommendUser(user));
    }
}
