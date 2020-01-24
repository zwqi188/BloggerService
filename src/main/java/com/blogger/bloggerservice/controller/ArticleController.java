package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.form.ArticleForm;
import com.blogger.bloggerservice.service.ArticleService;
import com.blogger.bloggerservice.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author admin
 */
@Controller
@Validated
@RequestMapping(value = "/sys")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/uploadArticle.json", method = RequestMethod.POST)
    @ResponseBody
    public String uploadArticle(@Validated(value = ArticleForm.UploadArticle.class) ArticleForm articleForm) {
        return JsonUtils.objectToString(articleService.uploadArticle(articleForm));
    }


    @RequestMapping(value = "/getBlogList.json", method = RequestMethod.POST)
    @ResponseBody
    public String getBlogList(@Validated(value = ArticleForm.BlogList.class) ArticleForm articleForm) {
        return JsonUtils.objectToString(articleService.getBlogList(articleForm));
    }

}
