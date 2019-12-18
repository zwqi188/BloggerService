package com.blogger.bloggerservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author admin
 * 留言表
 */
@Getter
@Setter
@Entity
@Table(name="tb_word")
public class Word {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    /**
     * 留言标题
     */
    @Column(name="word_title")
    private Integer wordTitle;

    /**
     * 留言内容
     */
    @Column(name="wordContent")
    private String wordContent;

    /**
     * 留言人
     */
    @Column(name="master_id")
    private String masterId;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="updated_at")
    private Date updatedAt;

}
