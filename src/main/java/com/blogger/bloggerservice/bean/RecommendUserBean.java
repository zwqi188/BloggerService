package com.blogger.bloggerservice.bean;

import java.util.Date;

/**
 * @author admin
 */
public class RecommendUserBean {
    /**
     * id
     */
    private Integer id;

    /**
     * 用户头像
     */
    private String avatarUrl;
    /**
     * 登录名称
     */
    private String loginName;
    /**
     * 博主名称
     */
    private String userName;

    /**
     * 博主密码
     */
    private String userPassword;

    /**
     * 博主性别
     */
    private String userGender;

    /**
     * 博主邮箱
     */
    private String userEmail;

    /**
     * 用户字数
     */
    private Integer userWordNumber;

    /**
     * 用户喜爱数
     */
    private Integer userLike;

    private Boolean hasConcern;

    /**
     * 是否管理员
     */
    private Integer isAdmin;

    /**
     * 关注用户
     */
    private String userConcern;

    private Date createdAt;

    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getUserWordNumber() {
        return userWordNumber;
    }

    public void setUserWordNumber(Integer userWordNumber) {
        this.userWordNumber = userWordNumber;
    }

    public Integer getUserLike() {
        return userLike;
    }

    public void setUserLike(Integer userLike) {
        this.userLike = userLike;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getHasConcern() {
        return hasConcern;
    }

    public void setHasConcern(Boolean hasConcern) {
        this.hasConcern = hasConcern;
    }

    public String getUserConcern() {
        return userConcern;
    }

    public void setUserConcern(String userConcern) {
        this.userConcern = userConcern;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
