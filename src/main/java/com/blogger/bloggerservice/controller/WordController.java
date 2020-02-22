package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.form.CommentForm;
import com.blogger.bloggerservice.form.WordForm;
import com.blogger.bloggerservice.service.CommentService;
import com.blogger.bloggerservice.service.WordService;
import com.blogger.bloggerservice.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 留言
 * @author admin
 */
@Controller
@Validated
@RequestMapping(value = "/sys")
public class WordController {

    @Autowired
    private WordService wordService;
    /**
     * 获取博客类型
     * 接口名 /sys/queryWord.json
     * 入参
     * aritcleId          Integer|M|文章编号
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     * <p>
     * 示例
     *{
     * 	"code": "1000",
     * 	"message": "成功",
     * 	"data": [
     *                {
     * 			"createdAt": "Feb 20, 2020 8:52:12 PM",
     * 			"wordContent": "博主！你好啊",
     * 			"avatarUrl": "https://cdn2.jianshu.io/assets/default_avatar/2-9636b13945b9ccf345bc98d0d81074eb.jpg",
     * 			"loginName": "qzw"
     *        },
     *        {
     * 			"createdAt": "Feb 20, 2020 8:53:09 PM",
     * 			"wordContent": "博主！真厉害！",
     * 			"avatarUrl": "https://cdn2.jianshu.io/assets/default_avatar/2-9636b13945b9ccf345bc98d0d81074eb.jpg",
     * 			"loginName": "qzw"
     *        }
     * 	]
     * }
     *
     * @return
     */
    @RequestMapping(value = "/queryWord.json", method = RequestMethod.POST)
    @ResponseBody
    public String queryWord() {
        return JsonUtils.objectToString(wordService.queryWord());
    }

    /**
     * 获取博客类型
     * 接口名 /sys/publishComment.json
     * 入参
     * articleId          Integer|M|文章编号
     * reviewContent     String|M|评论
     * userId            Integer|M|用户编号
     *
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     * <p>
     * 示例
     *
     * @return
     */
    @RequestMapping(value = "/publishWord.json", method = RequestMethod.POST)
    @ResponseBody
    public String publishWord(@Validated(value = WordForm.PubishWord.class) WordForm form) {
        return JsonUtils.objectToString(wordService.publishWord(form));
    }
}
