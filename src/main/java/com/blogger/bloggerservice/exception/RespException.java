package com.blogger.bloggerservice.exception;


import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.response.Response;

/**
 * Created by apple on 19/3/18.
 */
public class RespException {

    private String respCode;

    private String respMsg;

    public RespException() {}

    public RespException(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    public RespException(ResponseEnums enums) {
        this.respCode = enums.getCode();
        this.respMsg = enums.getResponseMsg();
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

    public Response toResopnse() {
        return new Response(this.respCode, this.respMsg);
    }
}
