package com.blogger.bloggerservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author admin
 */
@Getter
@Setter
@Entity
@Table(name="tb_master")
public class Master {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    /**
     * 登录名称
     */
    @Column(name="login_name")
    private String loginName;
    /**
     * 博主名称
     */
    @Column(name="master_name")
    private String masterName;

    /**
     * 博主密码
     */
    @Column(name="master_password")
    private String masterPassword;

    /**
     * 博主性别
     */
    @Column(name="master_gender")
    private String masterGender;

    /**
     * 博主邮箱
     */
    @Column(name="master_email")
    private String masterEmail;

    /**
     * 是否管理员
     */
    @Column(name="is_admin")
    private Integer isAdmin;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="updated_at")
    private Date updatedAt;

}
