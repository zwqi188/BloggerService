package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.model.User;
import com.blogger.bloggerservice.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author admin
 */
@Controller
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
    public List<User> get() {
        System.out.println("get!");
        return homeService.getUser();
    }

}
