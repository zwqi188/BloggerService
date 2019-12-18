package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.form.QueryForm;
import com.blogger.bloggerservice.service.QueryService;
import com.blogger.bloggerservice.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/sys")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @RequestMapping(value = "/queryMenuList.json", method = RequestMethod.GET)
    @ResponseBody
    public String queryMenuList() {
        return JsonUtils.objectToString(queryService.queryMenuList());
    }
}
