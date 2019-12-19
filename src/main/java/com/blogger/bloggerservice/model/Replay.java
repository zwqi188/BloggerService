package com.blogger.bloggerservice.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author admin
 * 回复表
 */
@Entity
@Table(name="tb_replay")
public class Replay {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    /**
     * 评论id
     */
    @Column(name="review_id")
    private Integer reviewId;

    /**
     * 回复人id
     */
    @Column(name="master_id")
    private Integer masterId;

    /**
     * 是否有二级评论
     */
    @Column(name="has_replay")
    private Integer hasReplay;

    /**
     * 上级回复的id
     */
    @Column(name="replay_id")
    private Integer replayId;

    /**
     * 文章id
     */
    @Column(name="article_id")
    private Integer articleId;

    /**
     * 回复内容
     */
    @Column(name="replay_content")
    private String replayContent;


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

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
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

    public Integer getReplayId() {
        return replayId;
    }

    public void setReplayId(Integer replayId) {
        this.replayId = replayId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getReplayContent() {
        return replayContent;
    }

    public void setReplayContent(String replayContent) {
        this.replayContent = replayContent;
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
