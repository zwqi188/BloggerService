package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.form.QueryForm;
import com.blogger.bloggerservice.service.HomeService;
import com.blogger.bloggerservice.service.UtilService;
import com.blogger.bloggerservice.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
@Validated
@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private UtilService utilService;

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

    @RequestMapping(value = "/postImage.json")
    @ResponseBody
    public String postImage(MultipartFile file) {
        System.out.println("get!");
        return JsonUtils.objectToString(utilService.uploadImg(file));
    }

}
