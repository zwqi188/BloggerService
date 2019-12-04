package com.blogger.bloggerservice.enums;

/**
 *
 * @author mac
 * @date 2019/3/16
 */
public enum ResponseEnums {
    ERROR_LACK_PARAM("[T-1101]","缺少验证参数！"),
    ERROR_VARIFY_CHECK_CODE("[TV-1102]","验证码校验错误！"),
    ERROR_LOGIN_FAIL("[TV-1103]","用户名或密码错误！"),
    ERROR_NO_QUERY_RESULT("[TV-1104]","查询结果为空！"),
    ERROR_SAVE_TO_DATEBASE("[TV-1105]","保存数据库出错！");


    ResponseEnums (String code, String msg) {
        this.code = code;
        this.message = msg;
    }

    /**
     * code
     */
    private String code;

    /**
     * message
     */
    private String message;

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
