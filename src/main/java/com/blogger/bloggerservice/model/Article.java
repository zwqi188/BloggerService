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
@Table(name="tb_article")
public class Article {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    /**
     * 文章类型编号
     */
    @Column(name="article_type_id")
    private Integer articleTypeId;

    /**
     * 文章标题
     */
    @Column(name="article_title")
    private String articleTitle;

    /**
     * 文章内容
     */
    @Column(name="article_content")
    private String articleContent;

    /**
     * 文章信息
     */
    @Column(name="article_info")
    private String articleInfo;

    /**
     * 点击数量
     */
    @Column(name="article_count")
    private Integer articleCount;

    /**
     * 文章来源
     */
    @Column(name="article_from")
    private String articleFrom;

    /**
     * 创作人id
     */
    @Column(name="master_id")
    private Integer masterId;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="updated_at")
    private Date updatedAt;

}
