package com.blogger.bloggerservice.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by mac on 2019/4/20.
 * 公用工具类
 */
public class ComUtils {
    /**
     * 通过地址获取图片文件信息
     * @return
     */
    public static BufferedImage readImageFile(File file) {
        try{
            BufferedImage image = ImageIO.read(file);
            return image;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
