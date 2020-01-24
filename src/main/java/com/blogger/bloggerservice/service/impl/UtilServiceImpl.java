package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.constant.Constant;
import com.blogger.bloggerservice.service.UtilService;
import com.blogger.bloggerservice.utils.ComUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * 工具类方法
 *
 * @author admin
 */
@Service
public class UtilServiceImpl implements UtilService {
    /**
     * 上传图片接口
     *
     * @param file
     * @return
     */
    @Override
    public Map<String, Object> uploadImg(MultipartFile file) {
        Map<String, Object> returnMap = new HashMap<>();
        String path = Constant.UPLOAD_IMG_PATH + UUID.randomUUID().toString();
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //返回原来在客户端的文件系统的文件名
        String fileName = UUID.randomUUID() + ".jpg";
        //根据 dir 抽象路径名和 img 路径名字符串创建一个新 File 实例。
        FileOutputStream imgOut = null;
        try {
            imgOut = new FileOutputStream(new File(dir, fileName));
            //返回一个字节数组文件的内容
            imgOut.write(file.getBytes());
            imgOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            returnMap.put("location", null);
        }
        String rpath = path + "/" + fileName;
        returnMap.put("location", rpath);
        return returnMap;

    }

    /**
     * 生成图片验证码
     *
     * @return
     */
    @Override
    public BufferedImage generateVarifyCode(String varifyCode) {
        //创建BufferedImage对象,其作用相当于一图片
        BufferedImage image = new BufferedImage(Constant.varifyCodeWidth, Constant.varifyCodeHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        Random random = new Random();
        Font font = new Font("华文宋体", Font.BOLD, 19); //定义字体样式
        g.setColor(ComUtils.getRandColor(200, 250));
        g.fillRect(0, 0, Constant.varifyCodeWidth, Constant.varifyCodeHeight);    //绘制背景
        g.setFont(font);                   //设置字体
        g.setColor(ComUtils.getRandColor(180, 200));

        //绘制20条颜色和位置全部为随机产生的线条,该线条为2f
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(Constant.varifyCodeWidth - 1);
            int y = random.nextInt(Constant.varifyCodeHeight - 1);
            int x1 = random.nextInt(2) + 1;
            int y1 = random.nextInt(4) + 1;
            BasicStroke bs = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); //定制线条样式
            Line2D line = new Line2D.Double(x, y, x + x1, y + y1);
            g2d.setStroke(bs);
            g2d.draw(line);     //绘制直线
        }
        //输出由英文，数字，和中文随机组成的验证文字，具体的组合方式根据生成随机数确定。
        String ctmp = "";
        int itmp = 0;
        //制定输出的验证码为四位
        for (int i = 0; i < 4; i++) {
            switch (random.nextInt(3)) {
                case 1:     //生成A-Z的字母
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
            if (scaleSize > 1f) scaleSize = 1f;
            trans.scale(scaleSize, scaleSize);
            g2d_word.setTransform(trans);
            g.drawString(ctmp, 19 * i + 19, 19);
        }
        //释放g所占用的系统资源
        g.dispose();
        return image;
    }
}
