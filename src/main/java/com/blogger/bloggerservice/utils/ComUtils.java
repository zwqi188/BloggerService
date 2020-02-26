package com.blogger.bloggerservice.utils;

import com.blogger.bloggerservice.constant.Constant;
import com.blogger.bloggerservice.constant.Param;
import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.exception.RespException;
import com.blogger.bloggerservice.filter.CrossFilter;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by mac on 2019/4/20.
 * 公用工具类
 */
public class ComUtils {

    private static Logger logger = LoggerFactory.getLogger(ComUtils.class);
    /**
     * 通过地址获取图片文件信息
     *
     * @return
     */
    public static BufferedImage readImageFile(File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 该方法主要作用是获得随机生成的颜色
     */
    public static Color getRandColor(int s, int e) {
        Random random = new Random();
        if (s > 255) {
            s = 91;
        }
        if (e > 255) {
            e = 97;
        }
        int r, g, b;
        //随机生成RGB颜色中的r值
        r = s + random.nextInt(e - s);
        //随机生成RGB颜色中的g值
        g = s + random.nextInt(e - s);
        //随机生成RGB颜色中的b值
        b = s + random.nextInt(e - s);
        return new Color(r, g, b);
    }

    /**
     * 设置session
     *
     * @param request
     * @param key
     * @param value
     * @throws RespException
     */
    public static void setSession(HttpServletRequest request, String key, String value) throws RespException {
        try {
            HttpSession session = request.getSession(true);
            // 把当前生成的验证码存在session中，当用户输入后进行对比
            session.setAttribute(key, value);
            // 设置session过期时间
            session.setMaxInactiveInterval(Constant.SESSION_TIME);
            logger.info("保存session成功，[key]:" + key + ",[value]:" + value);
            String value2 = (String)session.getAttribute(key);
            logger.info("保存好立即获取session，[key]:" + key + ",[value]:" + value2);
        } catch (Exception e) {
            logger.error("保存session失败， [key] :" + key + ", [value] :" + value + ", [Exception] " + e);
            throw new RespException(ResponseEnums.EXP_UTL_SET_SESSION);
        }
    }

    /**
     * 根据key值获取session
     *
     * @param request
     * @param key
     * @return
     * @throws RespException
     */
    public static String getSession(HttpServletRequest request, String key) throws RespException {
        try {
            HttpSession session = request.getSession(true);
            // 把当前生成的验证码存在session中，当用户输入后进行对比
            // 设置session过期时间
            session.setMaxInactiveInterval(Constant.SESSION_TIME);
            String value = (String)session.getAttribute(key);
            logger.info("获取session成功，[key]:" + key + ",[value]:" + value);
            return (value) ;
        } catch (Exception e) {
            logger.error("获取session成功，[key]:" + key + ", [Exception] " + e);
            throw new RespException(ResponseEnums.EXP_UTL_GET_SESSION);
        }
    }

    /**
     * 根据key值删除session
     *
     * @param request
     * @param key
     * @return
     * @throws RespException
     */
    public static void cleanSession(HttpServletRequest request, String key) throws RespException {
        try {
            HttpSession session = request.getSession(true);
            // 把当前生成的验证码存在session中，当用户输入后进行对比
            session.removeAttribute(key);
        } catch (Exception e) {
            throw new RespException(ResponseEnums.EXP_UTL_REMOVE_SESSION);
        }
    }

    /**
     * 将用户关注的信息转换为列表
     * @param userConcern
     * @return
     */
    public static Integer[] convertConcernList(String userConcern) {
        if (StringUtils.isEmpty(userConcern)) {
            return new Integer[0];
        }
        String[] split = userConcern.split(",");
        return (Integer[]) ConvertUtils.convert(split, Integer.class);
    }

    /**
     * 生成关注数据
     * @param array
     * @param userId
     * @return
     */
    public static Integer[] follow(Integer array[], int userId) {
        Boolean exist = false;
        Integer[] arrNew = new Integer[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != userId) {
                arrNew[i] = array[i];
            } else {
                exist = true;
            }
        }
        if (!exist) {
            arrNew[array.length] = userId;
        }
        return arrNew;
    }

    /**
     * 生成取消关注数据
     * @param array
     * @param userId
     * @return
     */
    public static Integer[] unfollow(Integer array[], int userId) {
        Integer[] arrNew = new Integer[array.length - 1];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != userId) {
                arrNew[j] = array[i];
                j++;
            }
        }
        return arrNew;
    }


    /**
     * 转换为关注字符串
     * @param array
     * @return
     */
    public static String convertFollowList(Integer[] array) {
        String builder = "";
        for (int i = 0; i < array.length; i++) {
            builder = builder + array[i] + ",";
        }
        return builder.substring(0, builder.length() - 1);
    }

    public static List<Integer> convertUserIdList(String userConcern) {
        if (StringUtils.isEmpty(userConcern)) {
            return null;
        }
        List<Integer> userList = new ArrayList<>();
        String[] splitId = userConcern.split(",");
        for (String id: splitId) {
            userList.add(Integer.valueOf(id));
        }
        return userList;
    }

    public static String generateIdString(List<Integer> userIdList, Integer currentIndex, Integer size) {
        if (userIdList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Integer index = 0;
        for (int i = currentIndex; i < userIdList.size(); i++) {
            if (index < size) {
                index ++;
                sb.append("'" + userIdList.get(i) + "',");
            }
        }
        if (StringUtils.isEmpty(sb.toString())) {
            return null;
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static List<Map<String, Object>> hasConcern(List<Map<String, Object>> returnList, boolean b) {
        for(int i = 0; i < returnList.size(); i++) {
            returnList.get(i).put(Param.HAS_CONCERN, b);
        }
        return returnList;
    }
}
