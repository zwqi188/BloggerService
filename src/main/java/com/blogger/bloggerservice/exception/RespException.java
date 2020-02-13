package com.blogger.bloggerservice.exception;


import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.response.ResultVo;

/**
 * @author apple
 * @date 19/3/18
 */
public class RespException extends Exception {

    private String code;

    private String message;

    public RespException() {
    }

    public RespException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public RespException(ResponseEnums enums) {
        this.code = enums.getCode();
        this.message = enums.getResponseMsg();
    }


    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public ResultVo toResopnse() {
        return new ResultVo(this.code, this.message);
    }
}
