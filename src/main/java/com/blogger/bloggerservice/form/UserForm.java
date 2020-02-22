package com.blogger.bloggerservice.form;

import javax.validation.constraints.NotNull;

/**
 * @author admin
 */
public class UserForm {

    @NotNull(message = "用户id不能为空", groups = {LoginOut.class, GetRecommendUser.class, Query.class, Update.class, UpdatePassword.class})
    private Integer userId;

    @NotNull(message = "推荐用户索引不能为空", groups = {GetRecommendUser.class})
    private Integer index;

    @NotNull(message = "登录名不能为空", groups = {Login.class, Register.class})
    private String userName;

    @NotNull(message = "用户密码不能为空", groups = {Login.class, Register.class, UpdatePassword.class})
    private String userPassword;

    @NotNull(message = "验证码不能为空", groups = {Register.class})
    private String varifyCode;

    @NotNull(message = "原密码不能为空", groups = {UpdatePassword.class})
    private String orignPassword;

    private String avatarUrl;

    private String loginName;

    private String userGender;

    private String userMobile;

    private String userEmail;

    public UserForm() {
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getOrignPassword() {
        return orignPassword;
    }

    public void setOrignPassword(String orignPassword) {
        this.orignPassword = orignPassword;
    }

    public interface Login {
    }

    public interface Register {
    }

    public interface LoginOut {
    }

    public interface GetRecommendUser {
    }

    public interface Query {
    }

    public interface Update {
    }

    public interface UpdatePassword {
    }
}
