package com.blogger.bloggerservice.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author admin
 */
@Entity
@Table(name="tb_user")
public class User {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    /**
     * 用户头像
     */
    @Column(name = "avatar_url")
    private String avatarUrl;
    /**
     * 登录名称
     */
    @Column(name="login_name")
    private String loginName;
    /**
     * 博主名称
     */
    @Column(name="user_name")
    private String userName;

    /**
     * 博主密码
     */
    @Column(name="user_password")
    private String userPassword;

    /**
     * 博主性别
     */
    @Column(name="user_gender")
    private String userGender;

    /**
     * 博主邮箱
     */
    @Column(name="user_email")
    private String userEmail;


    @Column(name="user_mobile")
    private String userMobile;
    /**
     * 用户字数
     */
    @Column(name = "user_word_number")
    private Integer userWordNumber;

    /**
     * 用户喜爱数
     */
    @Column(name = "user_like")
    private Integer userLike;

    /**
     * 是否管理员
     */
    @Column(name="is_admin")
    private Integer isAdmin;

    /**
     * 关注用户
     */
    @Column(name = "user_concern")
    private String userConcern;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="updated_at")
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
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

    public String getUserConcern() {
        return userConcern;
    }

    public void setUserConcern(String userConcern) {
        this.userConcern = userConcern;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }
}
