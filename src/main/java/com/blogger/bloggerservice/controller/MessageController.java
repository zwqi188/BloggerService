package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.form.MessageForm;
import com.blogger.bloggerservice.service.MessageService;
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
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 用户注册
     * 接口名 /sys/queryMessage.json
     * 入参
     * userId             Integer|M|用户id
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
     * 			"id": 1,
     * 			"sendId": 1,
     * 			"sendName": "张三",
     * 			"messageType": 1,
     * 			"receiverName": "哈哈",
     * 			"receiverId": 2,
     * 			"messageContent": "hahha",
     * 			"hasRead": 0,
     * 			"createdAt": "Feb 27, 2020, 11:24:39 AM"
     *        },
     *        {
     * 			"id": 2,
     * 			"sendId": 3,
     * 			"sendName": "李四",
     * 			"messageType": 2,
     * 			"receiverName": "哈哈",
     * 			"receiverId": 2,
     * 			"messageContent": "3号关注了你",
     * 			"hasRead": 1,
     * 			"createdAt": "Feb 27, 2020, 11:24:43 AM"
     *        }
     * 	]
     * }
     *
     * @return
     */
    @RequestMapping(value = "/queryMessage.json", method = RequestMethod.POST)
    @ResponseBody
    public String queryMessage(@Validated(value = MessageForm.QueryMessage.class) MessageForm form) {
        return JsonUtils.objectToString(messageService.queryMessage(form));
    }

    /**
     * 用户注册
     * 接口名 /sys/deleteMessage.json
     * 入参
     * id             Integer|M|用户id
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     * <p>
     * 示例
     *
     *
     * @return
     */
    @RequestMapping(value = "/deleteMessage.json", method = RequestMethod.POST)
    @ResponseBody
    public String deleteMessage(@Validated(value = MessageForm.DeleteMessage.class) MessageForm form) {
        return JsonUtils.objectToString(messageService.deleteMessage(form));
    }


    /**
     * 查询未看列表
     * 接口名 /sys/getMessageCount.json
     * 入参
     * userId             Integer|M|用户id
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
     * 		"other": 2,
     * 		"comment": 3,
     * 		"follow": 1,
     * 		"thumbs": 3
     *        }
     * }
     *
     * @return
     */
    @RequestMapping(value = "/getMessageCount.json", method = RequestMethod.POST)
    @ResponseBody
    public String getMessageCount(@Validated(value = MessageForm.CountMessage.class) MessageForm form) {
        return JsonUtils.objectToString(messageService.getMessageCount(form));
    }


    /**
     * 查询未看列表
     * 接口名 /sys/updateReadStatus.json
     * 入参
     * userId             Integer|M|用户id
     * messageType        Integer|M|消息类型
     * 出参
     * code            String|M|返回码
     * message             String|M|返回话术
     * data                Object|O|信息
     * <p>
     * 示例
     *
     * @return
     */
    @RequestMapping(value = "/updateReadStatus.json", method = RequestMethod.POST)
    @ResponseBody
    public String updateReadStatus(@Validated(value = MessageForm.ReadMessage.class) MessageForm form) {
        return JsonUtils.objectToString(messageService.updateReadStatus(form));
    }

}
