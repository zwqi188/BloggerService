package com.blogger.bloggerservice.enums;

import com.blogger.bloggerservice.constant.Constant;

/**
 * 标准 错误(ERROR)/异常(EXP) + 位置（COT/SEV/UTL）+ 具体参数/方法/功能
 *
 * @author mac
 * @date 2019/3/16
 */
public enum ResponseEnums {
    ERROR_LACK_PARAM(Constant.RESP_CODE_1001, "缺少验证参数！[BS-1001]"),
    ERROR_VARIFY_CHECK_CODE(Constant.RESP_CODE_1001, "验证码校验错误！[BS-1002]"),
    ERROR_LOGIN_FAIL(Constant.RESP_CODE_1001, "用户名或密码错误！[BS-1003]"),
    ERROR_NO_QUERY_RESULT(Constant.RESP_CODE_1001, "查询结果为空！[BS-1004]"),
    ERROR_SAVE_TO_DATEBASE(Constant.RESP_CODE_1001, "保存数据库出错！[BS-1005]"),

    EXP_UTL_SET_SESSION(Constant.RESP_CODE_1001, "系统异常! [BS-2001]"),
    EXP_UTL_GET_SESSION(Constant.RESP_CODE_1001, "系统异常! [BS-2002]"),
    EXP_UTL_REMOVE_SESSION(Constant.RESP_CODE_1001, "系统异常! [BS-2003]"),

    ERROR_SEV_VARIFY_CODE(Constant.RESP_CODE_1001, "验证码错误！[BS-3001]"),
    ERROR_SEV_USER_EXIST(Constant.RESP_CODE_1001, "用户信息已存在！[BS-3002]"),
    ERROR_SEV_USER_NOT_EXIST(Constant.RESP_CODE_1001, "用户信息不存在！[BS-3002]"),

    EXP_FIL_CHECK_PARAM(Constant.RESP_CODE_9501, "参数错误！[BS-4001]");

    /**
     * code
     */
    private String code;

    /**
     * message
     */
    private String message;

    ResponseEnums(String code, String msg) {
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
     *
     * @return
     */
    public String getResponseMsg() {
        return message + code;
    }
}
