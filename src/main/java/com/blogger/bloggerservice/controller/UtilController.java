package com.blogger.bloggerservice.controller;

import com.blogger.bloggerservice.constant.Constant;
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
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author admin
 */
@Validated
@Controller
@RequestMapping(value = "/sys")
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
        BufferedImage image = this.generateVarifyCode(request, varifyCode);
        //输出图片
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }

    /**
     * 生成图片验证码
     * @param varifyCode
     * @return
     */
    private BufferedImage generateVarifyCode(HttpServletRequest request,String varifyCode) throws RespException {
        //创建BufferedImage对象,其作用相当于一图片
        BufferedImage image = new BufferedImage(Constant.varifyCodeWidth,
                Constant.varifyCodeHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        Random random = new Random();
        //定义字体样式
        Font font = new Font("华文宋体", Font.BOLD, 19);
        g.setColor(ComUtils.getRandColor(200, 250));
        //绘制背景
        g.fillRect(0, 0, Constant.varifyCodeWidth, Constant.varifyCodeHeight);
        //设置字体
        g.setFont(font);
        g.setColor(ComUtils.getRandColor(180, 200));

        //绘制20条颜色和位置全部为随机产生的线条,该线条为2f
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(Constant.varifyCodeWidth - 1);
            int y = random.nextInt(Constant.varifyCodeHeight - 1);
            int x1 = random.nextInt(2) + 1;
            int y1 = random.nextInt(4) + 1;
            //定制线条样式
            BasicStroke bs = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
            Line2D line = new Line2D.Double(x, y, x + x1, y + y1);
            g2d.setStroke(bs);
            //绘制直线
            g2d.draw(line);
        }
        //输出由英文，数字，和中文随机组成的验证文字，具体的组合方式根据生成随机数确定。
        String ctmp = "";
        int itmp = 0;
        //制定输出的验证码为四位
        for (int i = 0; i < 4; i++) {
            switch (random.nextInt(3)) {
                //生成A-Z的字母
                case 1:
                    itmp = random.nextInt(26) + 65;
                    ctmp = String.valueOf((char) itmp);
                    break;
                default:
                    //数字
                    itmp = random.nextInt(10) + 48;
                    ctmp = String.valueOf((char) itmp);
                    break;
            }
            varifyCode += ctmp;
            Color color = new Color(20 + random.nextInt(110), 20 + random.nextInt(110), random.nextInt(110));
            g.setColor(color);
            //将生成的随机数进行随机缩放并旋转制定角度 PS.建议不要对文字进行缩放与旋转,因为这样图片可能不正常显示
            /*将文字旋转制定角度*/
            Graphics2D g2d_word = (Graphics2D) g;
            AffineTransform trans = new AffineTransform();
            trans.rotate((30) * 3.14 / 266, 19 * i + 8, 7);
            /*缩放文字*/
            float scaleSize = random.nextFloat() + 0.8f;
            if (scaleSize > 1f) {
                scaleSize = 1f;
            }
            trans.scale(scaleSize, scaleSize);
            g2d_word.setTransform(trans);
            g.drawString(ctmp, 19 * i + 19, 19);
        }
        //释放g所占用的系统资源
        ComUtils.setSession(request, Param.RAND_CHECK_CODE, varifyCode);
        g.dispose();
        return image;
    }

}
