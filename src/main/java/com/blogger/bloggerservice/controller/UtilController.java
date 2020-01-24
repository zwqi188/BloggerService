package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.constant.Param;
import com.blogger.bloggerservice.exception.RespException;
import com.blogger.bloggerservice.service.UtilService;
import com.blogger.bloggerservice.utils.ComUtils;
import com.blogger.bloggerservice.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author admin
 */
@Validated
@Controller
public class UtilController {

    @Autowired
    private UtilService utilService;


    /**
     * 上传图片接口
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploadImage.json")
    @ResponseBody
    public String upload(MultipartFile file) {
        System.out.println("get!");
        return JsonUtils.objectToString(utilService.uploadImg(file));
    }


    /**
     * 生成验证码接口
     *
     * @param request
     * @param response file
     * @throws IOException
     */
    @RequestMapping(value = "/generateRandCheckCode.json", method = RequestMethod.GET)
    public void generateRandCheckCode(HttpServletRequest request, HttpServletResponse response)
            throws IOException, RespException {
        //设置不缓存图片
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        //指定生成的响应图片,一定不能缺少这句话,否则错误.
        response.setContentType("image/jpeg");
        String varifyCode = "";
        BufferedImage image = utilService.generateVarifyCode(varifyCode);
        ComUtils.setSession(request, Param.RAND_CHECK_CODE, varifyCode);
        ImageIO.write(image, "JPEG", response.getOutputStream()); //输出图片
    }

}
