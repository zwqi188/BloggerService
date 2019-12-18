package com.blogger.bloggerservice.enums;

import com.blogger.bloggerservice.constant.Constant;

/**
 *
 * @author mac
 * @date 2019/3/16
 */
public enum ResponseEnums {
    ERROR_LACK_PARAM(Constant.RESP_CODE_1001,"缺少验证参数！[BL-1001]"),
    ERROR_VARIFY_CHECK_CODE(Constant.RESP_CODE_1001,"验证码校验错误！[BL-1002]"),
    ERROR_LOGIN_FAIL(Constant.RESP_CODE_1001,"用户名或密码错误！[BL-1003]"),
    ERROR_NO_QUERY_RESULT(Constant.RESP_CODE_1001,"查询结果为空！[BL-1004]"),
    ERROR_SAVE_TO_DATEBASE(Constant.RESP_CODE_1001,"保存数据库出错！[BL-1005]");

    /**
     * code
     */
    private String code;

    /**
     * message
     */
    private String message;

    ResponseEnums (String code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 返回验证话术
     * @return
     */
    public String getResponseMsg(){
        return message + code;
    }
}
