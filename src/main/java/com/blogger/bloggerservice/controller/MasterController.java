package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.form.LoginForm;
import com.blogger.bloggerservice.service.LoginService;
import com.blogger.bloggerservice.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author admin
 */
@Controller
@RequestMapping(value = "/sys")
public class MasterController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login.json", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody @Validated(value = LoginForm.Login.class) LoginForm login) {
        return JsonUtils.objectToString(loginService.login(login));
    }
}
