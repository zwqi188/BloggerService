package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.service.UtilService;
import com.blogger.bloggerservice.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
@Validated
@Controller
public class UtilController {

    @Autowired
    private UtilService utilService;


    @RequestMapping(value = "/uploadImage.json")
    @ResponseBody
    public String upload(MultipartFile file) {
        System.out.println("get!");
        return JsonUtils.objectToString(utilService.uploadImg(file));
    }
}
