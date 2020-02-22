package com.blogger.bloggerservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author admin
 */
@Entity
@Table(name = "tb_article")
public class Article {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 文章类型编号
     */
    @Column(name = "article_type_id")
    private Integer articleTypeId;

    /**
     * 文章标题
     */
    @Column(name = "article_title")
    private String articleTitle;

    /**
     * 文章图片
     */
    @Column(name = "article_pic")
    private String articlePic;

    /**
     * 文章描述
     */
    @Column(name = "article_desc")
    private String articleDesc;
    /**
     * 文章内容
     */
    @Column(name = "article_content")
    private String articleContent;

    /**
     * 文章字数
     */
    @Column(name = "article_count")
    private Integer articleCount;
    /**
     * 文章信息
     */
    @Column(name = "article_info")
    private String articleInfo;

    /**
     * 点击数量
     */
    @Column(name = "article_like")
    private Integer articleLike;


    @Column(name = "article_replay")
    private Integer articleReplay;
    /**
     * 文章来源
     */
    @Column(name = "article_from")
    private String articleFrom;

    /**
     * 创作人id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名字
     */
    @Column(name = "user_name")
    private String userName;


    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at")
    private Date createdAt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at")
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(String articleInfo) {
        this.articleInfo = articleInfo;
    }

    public String getArticleFrom() {
        return articleFrom;
    }

    public void setArticleFrom(String articleFrom) {
        this.articleFrom = articleFrom;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleReplay() {
        return articleReplay;
    }

    public void setArticleReplay(Integer articleReplay) {
        this.articleReplay = articleReplay;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getArticlePic() {
        return articlePic;
    }

    public void setArticlePic(String articlePic) {
        this.articlePic = articlePic;
    }

    public Integer getArticleLike() {
        return articleLike;
    }

    public void setArticleLike(Integer articleLike) {
        this.articleLike = articleLike;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }
}
