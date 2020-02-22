package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.exception.RespException;
import com.blogger.bloggerservice.form.FollowForm;
import com.blogger.bloggerservice.form.UserForm;
import com.blogger.bloggerservice.service.FollowService;
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
public class FollowController {

    @Autowired
    private FollowService followService;

    /**
     * 关注
     * 接口名 /sys/follow.json
     * 入参
     * userId           Integer|M|用户Id
     * followId          Integer|M|关注Id
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     * <p>
     * 示例
     *{
     * 	"code": "1000",
     * 	"message": "成功"
     * }
     * @return
     */
    @RequestMapping(value = "/follow.json", method = RequestMethod.POST)
    @ResponseBody
    public String follow(@Validated(value = FollowForm.Follow.class) FollowForm form) throws RespException {
        return JsonUtils.objectToString(followService.follow(form));
    }

    /**
     * 取消关注
     * 接口名 /sys/unfollow.json
     * 入参
     * userId           Integer|M|用户Id
     * followId          Integer|M|关注Id
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     * <p>
     * 示例
     *{
     * 	"code": "1000",
     * 	"message": "成功"
     * }
     * @return
     */
    @RequestMapping(value = "/unfollow.json", method = RequestMethod.POST)
    @ResponseBody
    public String unfollow(@Validated(value = FollowForm.UnFollow.class) FollowForm form) throws RespException {
        return JsonUtils.objectToString(followService.UnFollow(form));
    }

    /**
     * 查询我的关注
     * 接口名 /sys/queryfollowByUserId.json
     * 入参
     * userId           Integer|M|用户Id
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
     * 			"id": 1,
     * 			"avatarUrl": "https://cdn2.jianshu.io/assets/default_avatar/2-9636b13945b9ccf345bc98d0d81074eb.jpg",
     * 			"loginName": "qzw",
     * 			"userName": "张三",
     * 			"userPassword": "202cb962ac59075b964b07152d234b70",
     * 			"userGender": "男",
     * 			"userEmail": "16465465@qq.com",
     * 			"userWordNumber": 344,
     * 			"userLike": 43,
     * 			"isAdmin": 1,
     * 			"userConcern": "1,4,9,0,0,null,null",
     * 			"createdAt": "Feb 20, 2020 12:10:34 PM",
     * 			"updatedAt": "Feb 20, 2020 12:10:34 PM"
     *        },
     *        {
     * 			"id": 4,
     * 			"avatarUrl": "https://upload.jianshu.io/users/upload_avatars/3950651/acfaa0ce-42fe-424a-b7c8-9a0136fb96ec.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/96/h/96/format/webp",
     * 			"loginName": "756756胡",
     * 			"userName": "87686",
     * 			"userPassword": "565",
     * 			"userGender": "男",
     * 			"userEmail": "765765",
     * 			"userWordNumber": 5,
     * 			"userLike": 4,
     * 			"isAdmin": 0,
     * 			"userConcern": "4,6",
     * 			"createdAt": "Feb 13, 2020 8:31:54 PM",
     * 			"updatedAt": "Feb 13, 2020 8:31:54 PM"
     *        },
     *        {
     * 			"id": 9,
     * 			"loginName": "0980",
     * 			"userName": "0980",
     * 			"userPassword": "d41d8cd98f00b204e9800998ecf8427e",
     * 			"userConcern": "",
     * 			"createdAt": "Feb 20, 2020 12:05:06 PM",
     * 			"updatedAt": "Feb 20, 2020 12:05:06 PM"
     *        }
     * 	]
     * }
     * @return
     */
    @RequestMapping(value = "/queryfollowByUserId.json", method = RequestMethod.POST)
    @ResponseBody
    public String queryfollowByUserId(@Validated(value = FollowForm.QueryFollow.class) FollowForm form) throws RespException {
        return JsonUtils.objectToString(followService.queryfollowByUserId(form));
    }
}
