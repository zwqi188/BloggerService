package com.blogger.bloggerservice.response;

import com.blogger.bloggerservice.enums.ResponseEnums;

/**
 * Created by apple on 19/3/6.
 */
public class ResultVo {

    private String respCode;

    private String respMsg;

    private Object data;

    public ResultVo() {}

    public ResultVo(String code, String message) {
        this.respCode = code;
        this.respMsg = message;
    }

    public ResultVo(String code, String message, Object data) {
        this.respCode = code;
        this.respMsg = message;
        this.data = data;
    }

    public ResultVo (ResponseEnums enums) {
        this.respCode = enums.getCode();
        this.respMsg = enums.getMessage();
    }
    public static ResultVo success(){
        return new ResultVo("1000", "成功");
    }

    public static ResultVo success(String respMsg){
        return new ResultVo("1000", respMsg);
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

    public static ResultVo fail(String respMsg){
        return new ResultVo("1001", respMsg);
    }

    public static ResultVo fail(StringBuilder respMsg){
        return new ResultVo("1001", "失败", respMsg);
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
