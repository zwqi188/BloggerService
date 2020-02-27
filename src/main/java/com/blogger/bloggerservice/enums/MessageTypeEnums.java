package com.blogger.bloggerservice.enums;

/**
 * 信息类型
 * @author admin
 */
public enum MessageTypeEnums {
    COMMENT(1, "评论"),
    FOLLOW(2, "关注"),
    THUMBS(3, "点赞"),
    OTHER(4, "其他");
    /**
     * code
     */
    private Integer code;

    /**
     * message
     */
    private String name;

    MessageTypeEnums(Integer code, String msg) {
        this.code = code;
        this.name = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
