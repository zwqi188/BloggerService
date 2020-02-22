package com.blogger.bloggerservice.utils;

import com.blogger.bloggerservice.constant.Constant;
import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.exception.RespException;
import com.sun.org.apache.xml.internal.utils.res.StringArrayWrapper;
import org.apache.commons.beanutils.ConvertUtils;
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
import java.util.Random;

/**
 * Created by mac on 2019/4/20.
 * 公用工具类
 */
public class ComUtils {
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
        } catch (Exception e) {
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
            return (String) session.getAttribute(key);
        } catch (Exception e) {
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
}
