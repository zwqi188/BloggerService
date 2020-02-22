package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.exception.RespException;
import com.blogger.bloggerservice.form.ThumbsForm;
import com.blogger.bloggerservice.form.UserForm;
import com.blogger.bloggerservice.service.ThumbsService;
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
 * 点赞管理
 * @author admin
 */
@Controller
@Validated
@RequestMapping(value = "/sys")
public class ThumbsController {

    @Autowired
    private ThumbsService thumbsService;

    /**
     * 用户注册
     * 接口名 /sys/register.json
     * 入参
     * userId           String|M|用户名
     * articleId       String|M|用户密码
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     * <p>
     * 示例
     *
     * @return
     */
    @RequestMapping(value = "/thumbsUp.json", method = RequestMethod.POST)
    @ResponseBody
    public String thumbsUp(@Validated(value = ThumbsForm.ThumbsUp.class) ThumbsForm thumbs) throws RespException {
        return JsonUtils.objectToString(thumbsService.thumbsUp(thumbs));
    }

}
