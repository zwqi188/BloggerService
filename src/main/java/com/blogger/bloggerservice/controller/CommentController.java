package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.exception.RespException;
import com.blogger.bloggerservice.form.CommentForm;
import com.blogger.bloggerservice.form.UserForm;
import com.blogger.bloggerservice.service.CommentService;
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
 * @author admin
 */
@Controller
@Validated
@RequestMapping(value = "/sys")
public class CommentController {

    @Autowired
    private CommentService commentService;
    /**
     * 获取博客类型
     * 接口名 /sys/getCommentByArticleId.json
     * 入参
     * aritcleId          Integer|M|文章编号
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     * <p>
     * 示例
     * {
     * 	"code": "1000",
     * 	"message": "成功",
     * 	"data": [
     *                {
     * 			"avatarUrl": "https://upload.jianshu.io/users/upload_avatars/3950651/acfaa0ce-42fe-424a-b7c8-9a0136fb96ec.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/96/h/96/format/webp",
     * 			"userName": "756756胡",
     * 			"createdAt": "Feb 19, 2020 5:58:39 PM",
     * 			"reviewContent": "我去你大爷的"
     *        },
     *        {
     * 			"avatarUrl": "https://upload.jianshu.io/users/upload_avatars/3950651/acfaa0ce-42fe-424a-b7c8-9a0136fb96ec.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/96/h/96/format/webp",
     * 			"userName": "756756胡",
     * 			"createdAt": "Feb 19, 2020 5:58:50 PM",
     * 			"reviewContent": "54354"
     *        }
     * 	]
     * }
     *
     * @return
     */
    @RequestMapping(value = "/getCommentByArticleId.json", method = RequestMethod.POST)
    @ResponseBody
    public String getCommentByArticleId(@Validated(value = CommentForm.Comment.class) CommentForm form) {
        return JsonUtils.objectToString(commentService.getCommentByArticleId(form));
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
    @RequestMapping(value = "/publishComment.json", method = RequestMethod.POST)
    @ResponseBody
    public String publishComment(@Validated(value = CommentForm.PubishComment.class) CommentForm form) {
        return JsonUtils.objectToString(commentService.publishComment(form));
    }
}
