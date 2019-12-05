package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.form.QueryForm;
import com.blogger.bloggerservice.model.User;
import com.blogger.bloggerservice.service.HomeService;
import com.blogger.bloggerservice.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author admin
 */
@Controller
@Validated
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping(value="/home")
    public String home(){
        System.out.println("redirect to home page!");
        return "index.html";
    }

    @RequestMapping(value = "/get.json", method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        System.out.println("get!");
        return JsonUtils.objectToString(homeService.getUser());
    }

    @RequestMapping(value = "/testForm.json", method = RequestMethod.POST)
    @ResponseBody
    public String testForm(@Validated(value = QueryForm.Query.class) QueryForm form) {
        System.out.println("get!");
        return JsonUtils.objectToString(homeService.getUser());
    }

}
