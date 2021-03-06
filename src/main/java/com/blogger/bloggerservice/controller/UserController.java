package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.aspect.NeedCheckLogin;
import com.blogger.bloggerservice.exception.RespException;
import com.blogger.bloggerservice.form.RecommendForm;
import com.blogger.bloggerservice.form.UserForm;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.UserService;
import com.blogger.bloggerservice.utils.ComUtils;
import com.blogger.bloggerservice.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author admin
 */
@Controller
@Validated
@RequestMapping(value = "/sys")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * 接口名 /sys/register.json
     * 入参
     * userName           String|M|用户名
     * userPassword       String|M|用户密码
     * varifyCode         String|M|验证码
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     * <p>
     * 示例
     *
     * @return
     */
    @RequestMapping(value = "/register.json", method = RequestMethod.POST)
    @ResponseBody
    public String register(@Validated(value = UserForm.Register.class) UserForm login,
                           HttpServletRequest request) throws RespException {
        return JsonUtils.objectToString(userService.register(login, request));
    }

    /**
     * 用户登录
     * 接口名 /sys/login.json
     * 入参
     * userName           String|M|用户名
     * userPassword       String|M|用户密码
     * varifyCode         String|M|验证码
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * <p>
     * 示例
     *
     * @return
     */
    @RequestMapping(value = "/login.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo login(@Validated(value = UserForm.Login.class) UserForm login,
                        HttpServletRequest request) throws RespException {
        ResultVo result = userService.login(login, request);
        String token = UUID.randomUUID().toString();
        request.getSession().setAttribute(token, result.getData());
        result.setData(token);
        return result;
    }


    /**
     * 用户登出
     * 接口名 /sys/login.json
     * 入参
     * userName           String|M|用户名
     * userPassword       String|M|用户密码
     * varifyCode         String|M|验证码
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * <p>
     * 示例
     *
     * @return
     */
    @RequestMapping(value = "/loginOut.json", method = RequestMethod.POST)
    @ResponseBody
    public String loginOut(@RequestBody @Validated(value = UserForm.LoginOut.class) UserForm login,
                           HttpServletRequest request) throws RespException {
        return JsonUtils.objectToString(userService.loginOut(login, request));
    }


    /**
     * 获取博客类型
     * 接口名 /sys/getRecommendUser.json
     * 入参
     * userId           Integer|M|用户名
     * index            Integer|M|查询索引
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
     * 			"id": 2,
     * 			"avatarUrl": "https://upload.jianshu.io/users/upload_avatars/9988193/fc26c109-1ae6-4327-a298-2def343e9cd8.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/96/h/96/format/webp",
     * 			"loginName": "cxa",
     * 			"userName": "nihao",
     * 			"userPassword": "4234324",
     * 			"userGender": "女",
     * 			"userEmail": "weqe4234@qwre.com",
     * 			"userWordNumber": 3,
     * 			"userLike": 54,
     * 			"hasConcern": true,
     * 			"isAdmin": 0,
     * 			"userConcern": "3",
     * 			"createdAt": "Feb 13, 2020 8:31:50 PM",
     * 			"updatedAt": "Feb 13, 2020 8:31:50 PM"
     *        },
     *        {
     * 			"id": 3,
     * 			"avatarUrl": "https://upload.jianshu.io/users/upload_avatars/3343569/6940ee65-036f-4b7a-9935-5915d9b67d14.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/96/h/96/format/webp",
     * 			"loginName": "和规范化",
     * 			"userName": "4656",
     * 			"userPassword": "64654",
     * 			"userGender": "男",
     * 			"userEmail": "645654",
     * 			"userWordNumber": 4,
     * 			"userLike": 54,
     * 			"hasConcern": true,
     * 			"isAdmin": 0,
     * 			"createdAt": "Feb 13, 2020 6:49:23 PM",
     * 			"updatedAt": "Feb 13, 2020 6:49:23 PM"
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
     * 			"hasConcern": true,
     * 			"isAdmin": 0,
     * 			"userConcern": "4,6",
     * 			"createdAt": "Feb 13, 2020 8:31:54 PM",
     * 			"updatedAt": "Feb 13, 2020 8:31:54 PM"
     *        },
     *        {
     * 			"id": 6,
     * 			"avatarUrl": "https://upload.jianshu.io/users/upload_avatars/3950651/acfaa0ce-42fe-424a-b7c8-9a0136fb96ec.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/96/h/96/format/webp",
     * 			"loginName": "地",
     * 			"userName": "767",
     * 			"userPassword": "75",
     * 			"userGender": "女",
     * 			"userEmail": "756",
     * 			"userWordNumber": 54,
     * 			"userLike": 45,
     * 			"hasConcern": true,
     * 			"isAdmin": 0,
     * 			"userConcern": "3,9",
     * 			"createdAt": "Feb 13, 2020 8:32:15 PM",
     * 			"updatedAt": "Feb 13, 2020 8:32:15 PM"
     *        },
     *        {
     * 			"id": 1,
     * 			"avatarUrl": "https://cdn2.jianshu.io/assets/default_avatar/2-9636b13945b9ccf345bc98d0d81074eb.jpg",
     * 			"loginName": "qzw",
     * 			"userName": "张三",
     * 			"userPassword": "123456",
     * 			"userGender": "男",
     * 			"userEmail": "16465465@qq.com",
     * 			"userWordNumber": 344,
     * 			"userLike": 43,
     * 			"hasConcern": false,
     * 			"isAdmin": 1,
     * 			"userConcern": "2,3,4,6",
     * 			"createdAt": "Feb 13, 2020 8:31:47 PM",
     * 			"updatedAt": "Feb 13, 2020 8:31:47 PM"
     *        }
     * 	]
     * }
     * @return
     */
    @NeedCheckLogin
    @RequestMapping(value = "/getRecommendUser.json", method = RequestMethod.POST)
    @ResponseBody
    public String getRecommendUser(@Validated(value = RecommendForm.GetRecommendUser.class) RecommendForm form) {
        System.out.println("checkUserIdController:" + form.getId());
        return JsonUtils.objectToString(userService.getRecommendUser(form));
    }


    /**
     * 获取博客类型
     * 接口名 /sys/queryUser.json
     * 入参
     * userId           Integer|M|用户名
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     * <p>
     * 示例
     *{
     * 	"code": "1000",
     * 	"message": "成功",
     * 	"data": {
     * 		"id": 1,
     * 		"avatarUrl": "https://cdn2.jianshu.io/assets/default_avatar/2-9636b13945b9ccf345bc98d0d81074eb.jpg",
     * 		"loginName": "qzw",
     * 		"userName": "张三",
     * 		"userPassword": "202cb962ac59075b964b07152d234b70",
     * 		"userGender": "男",
     * 		"userEmail": "16465465@qq.com",
     * 		"userWordNumber": 344,
     * 		"userLike": 43,
     * 		"isAdmin": 1,
     * 		"userConcern": "1,4,9",
     * 		"createdAt": "Feb 20, 2020 2:59:59 PM",
     * 		"updatedAt": "Feb 20, 2020 2:59:59 PM"
     *        }
     * }
     * @return
     */
    @RequestMapping(value = "/queryUser.json", method = RequestMethod.POST)
    @ResponseBody
    public String queryUser(@Validated(value = UserForm.Query.class)UserForm user) {
        return JsonUtils.objectToString(userService.queryUser(user));
    }


    /**
     * 获取博客类型
     * 接口名 /sys/updateUser.json
     * 入参
     * userId           Integer|M|用户名
     * avatarUrl        String|O|头像
     * loginName        String|O|登录名
     * userGender        String|O|性别
     * userMobile        String|O|手机号
     * userEmail        String|O|邮箱
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     * <p>
     * 示例
     *
     * @return
     */
    @RequestMapping(value = "/updateUser.json", method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(@Validated(value = UserForm.Update.class)UserForm user) {
        return JsonUtils.objectToString(userService.saveUser(user));
    }

    /**
     * 获取博客类型
     * 接口名 /sys/updatePassword.json
     * 入参
     * userId           Integer|M|用户名
     * orignPassword        String|M|原密码
     * userPassword         String|M|密码
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     * <p>
     * 示例
     *
     * @return
     */
    @RequestMapping(value = "/updatePassword.json", method = RequestMethod.POST)
    @ResponseBody
    public String updatePassword(@Validated(value = UserForm.UpdatePassword.class)UserForm form) {
        return JsonUtils.objectToString(userService.updatePassword(form));
    }
}
