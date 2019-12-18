package com.blogger.bloggerservice.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author admin
 */
public class LoginForm {

    @NotNull(message = "登录名不能为空", groups = {Login.class})
    private String username;

    @NotNull(message = "登录密码不能为空", groups = {Login.class})
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public interface Login {}
}
