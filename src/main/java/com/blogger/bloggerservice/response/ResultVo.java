package com.blogger.bloggerservice.response;

import com.blogger.bloggerservice.enums.ResponseEnums;

/**
 * Created by apple on 19/3/6.
 */
public class ResultVo {

    private String code;

    private String message;

    private Object data;

    public ResultVo() {}

    public ResultVo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultVo(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultVo (ResponseEnums enums) {
        this.code = enums.getCode();
        this.message = enums.getMessage();
    }
    public static ResultVo success(){
        return new ResultVo("1000", "成功");
    }

    public static ResultVo success(String message){
        return new ResultVo("1000", message);
    }

    public static ResultVo success(Object data){
        return new ResultVo("1000", "成功", data);
    }

    public static ResultVo succ(String data){
        return new ResultVo("1000", "成功", data);
    }


    public static ResultVo fail(){
        return new ResultVo("1001", "失败");
    }

    public static ResultVo fail(String message){
        return new ResultVo("1001", message);
    }

    public static ResultVo fail(StringBuilder message){
        return new ResultVo("1001", "失败", message);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
