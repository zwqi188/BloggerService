package com.blogger.bloggerservice.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author admin
 * 回复表
 */
@Entity
@Table(name="tb_review")
public class Review {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    /**
     * 文章id
     */
    @Column(name="article_id")
    private Integer articleId;

    /**
     * 回复人id
     */
    @Column(name="master_id")
    private Integer masterId;

    /**
     * 有回复
     */
    @Column(name="has_replay")
    private Integer hasReplay;

    /**
     * 评论内容
     */
    @Column(name="review_content")
    private Integer reviewContent;

    /**
     * 评论状态
     */
    @Column(name="review_status")
    private String reviewStatus;


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

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public Integer getHasReplay() {
        return hasReplay;
    }

    public void setHasReplay(Integer hasReplay) {
        this.hasReplay = hasReplay;
    }

    public Integer getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(Integer reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
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
