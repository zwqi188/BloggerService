package com.blogger.bloggerservice.constant;

/**
 * @author admin
 */
public class Constant {

    public static final String RESP_CODE_1001 = "1001";

    public static final String RESP_CODE_9501 = "9501";

    /**
     * 上传图片地址
     */

    public static final String BATH_URL = "/usr/tomcat/tomcat/webapps";
    public static final String UPLOAD_IMG_PATH = "/uploadImg/";

    public static final String FILE_PATH = "/filePath/";

    /**
     * 验证码信息常量
     */
    public static final Integer varifyCodeWidth = 100;
    public static final Integer varifyCodeHeight = 28;
    public static final Integer SESSION_TIME = 60 * 60;
    /**
     * 默认推荐用户数量
     */
    public static final Integer RECOMMEND_USER_NUMBER = 5;
}
