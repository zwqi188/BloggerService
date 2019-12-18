package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.constant.Constant;
import com.blogger.bloggerservice.service.UtilService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *  工具类方法
 * @author admin
 */
@Service
public class UtilServiceImpl implements UtilService {
    @Override
    public Map<String, Object> uploadImg(MultipartFile file) {
        Map<String, Object> returnMap = new HashMap<>();
        String path = Constant.UPLOAD_IMG_PATH + UUID.randomUUID().toString();
        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        //返回原来在客户端的文件系统的文件名
        String fileName = UUID.randomUUID()+".jpg";
        //根据 dir 抽象路径名和 img 路径名字符串创建一个新 File 实例。
        FileOutputStream imgOut= null;
        try {
            imgOut = new FileOutputStream(new File(dir,fileName));
            //返回一个字节数组文件的内容
            imgOut.write(file.getBytes());
            imgOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            returnMap.put("location", null);
        }
        String rpath = path+"/"+fileName;
        returnMap.put("location", rpath);
        return returnMap;

    }
}
