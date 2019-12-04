package com.blogger.bloggerservice.response;

/**
 * Created by apple on 19/3/6.
 */
public class Response {

    private String respCode;

    private String respMsg;

    private Object data;

    public Response() {}

    public Response(String code, String message) {
        this.respCode = code;
        this.respMsg = message;
    }

    public Response(String code, String message, Object data) {
        this.respCode = code;
        this.respMsg = message;
        this.data = data;
    }

    public static Response success(){
        return new Response("1000", "成功");
    }

    public static Response success(String respMsg){
        return new Response("1000", respMsg);
    }

    public static Response success(Object data){
        return new Response("1000", "成功", data);
    }

    public static Response succ(String data){
        return new Response("1000", "成功", data);
    }


    public static Response fail(){
        return new Response("1001", "失败");
    }

    public static Response fail(String respMsg){
        return new Response("1001", respMsg);
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
