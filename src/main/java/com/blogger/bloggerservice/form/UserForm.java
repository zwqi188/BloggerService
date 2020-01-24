package com.blogger.bloggerservice.form;

import javax.validation.constraints.NotNull;

/**
 * @author admin
 */
public class UserForm {

    @NotNull(message = "用户id不能为空", groups = {LoginOut.class})
    private Integer id;

    @NotNull(message = "登录名不能为空", groups = {Login.class, Register.class})
    private String userName;

    @NotNull(message = "登录密码不能为空", groups = {Login.class, Register.class})
    private String userPassword;

    @NotNull(message = "验证码不能为空", groups = {Login.class, Register.class})
    private String varifyCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getVarifyCode() {
        return varifyCode;
    }

    public void setVarifyCode(String varifyCode) {
        this.varifyCode = varifyCode;
    }

    public interface Login {
    }

    public interface Register {
    }

    public interface LoginOut {
    }
}
