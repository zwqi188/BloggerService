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

    /**
     * 上传博客文章
     * 接口名 /sys/uploadArticle.json
     * 入参
     * articleTypeId            Int|M|博客分类id
     * articleTitle             String|M|博客标题
     * articleContent           String|M|博客内容
     * userId                   Int|M|用户标号
     *
     * 出参
     * respCode            String|M|返回码
     * respMsg             String|M|返回话术
     *
     *
     * 示例
     *
     *
     * @return
     */
    @RequestMapping(value = "/uploadArticle.json", method = RequestMethod.POST)
    @ResponseBody
    public String uploadArticle(@Validated(value = ArticleForm.UploadArticle.class) ArticleForm articleForm) {
        return JsonUtils.objectToString(articleService.uploadArticle(articleForm));
    }

    /**
     * 获取博客列表
     * 接口名 /sys/getBlogList.json
     * 入参
     * pageIndex            Int|M|页码
     * pageSize             Int|M|页数
     * 出参
     * respCode            String|M|返回码
     * respMsg             String|M|返回话术
     * data                Object|O|信息
     *  returnData          List
     *  currentPage         Int|M|当前页
     *  count               Int|M|总条数
     *
     * 示例
     * {
     * 	"respCode": "1000",
     * 	"respMsg": "成功",
     * 	"data": {
     * 		"returnData": [{
     * 			"id": 5,
     * 			"articleTypeId": 1,
     * 			"articleTitle": "test",
     * 			"articleContent": "undefined",
     * 			"userId": 1,
     * 			"createdAt": "Dec 22, 2019 3:01:18 PM",
     * 			"updatedAt": "Dec 22, 2019 3:01:18 PM"
     *                }, {
     * 			"id": 6,
     * 			"articleTypeId": 1,
     * 			"articleTitle": "test",
     * 			"articleContent": "undefined",
     * 			"userId": 1,
     * 			"createdAt": "Dec 22, 2019 3:01:18 PM",
     * 			"updatedAt": "Dec 22, 2019 3:01:18 PM"
     *        }, {
     * 			"id": 7,
     * 			"articleTypeId": 1,
     * 			"articleTitle": "test",
     * 			"articleContent": "undefined",
     * 			"userId": 1,
     * 			"createdAt": "Dec 22, 2019 3:01:18 PM",
     * 			"updatedAt": "Dec 22, 2019 3:01:18 PM"
     *        }, {
     * 			"id": 8,
     * 			"articleTypeId": 1,
     * 			"articleTitle": "test",
     * 			"articleContent": "undefined",
     * 			"userId": 1,
     * 			"createdAt": "Dec 22, 2019 3:01:18 PM",
     * 			"updatedAt": "Dec 22, 2019 3:01:18 PM"
     *        }],
     * 		"count": 16,
     * 		"currentPage": 2* 	}
     * }
     *
     * @return
     */
    @RequestMapping(value = "/getBlogList.json", method = RequestMethod.POST)
    @ResponseBody
    public String getBlogList(@Validated(value = ArticleForm.BlogList.class) ArticleForm articleForm) {
        return JsonUtils.objectToString(articleService.getBlogList(articleForm));
    }

    /**
     * 获取博客类型
     * 接口名 /sys/getArticleType.json
     * 入参
     * 无
     * 出参
     * respCode            String|M|返回码
     * respMsg             String|M|返回话术
     * data                Object|O|信息
     *
     * 示例
     * {
     * 	"respCode": "1000",
     * 	"respMsg": "成功",
     * 	"data": [{
     * 		"articleTypeName": "生活",
     * 		"id": 2
     *        }, {
     * 		"articleTypeName": "技术",
     * 		"id": 1
     *    }, {
     * 		"articleTypeName": "福利",
     * 		"id": 3
     *    }]
     * }
     *
     * @return
     */
    @RequestMapping(value = "/getArticleType.json", method = RequestMethod.POST)
    @ResponseBody
    public String getArticleType() {
        return JsonUtils.objectToString(articleService.getArticleType());
    }

}
