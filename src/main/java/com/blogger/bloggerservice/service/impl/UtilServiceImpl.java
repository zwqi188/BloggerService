package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.constant.Constant;
import com.blogger.bloggerservice.constant.Param;
import com.blogger.bloggerservice.form.ArticleForm;
import com.blogger.bloggerservice.model.Article;
import com.blogger.bloggerservice.repository.ArticleReposity;
import com.blogger.bloggerservice.service.UtilService;
import com.blogger.bloggerservice.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.*;

/**
 * 工具类方法
 *
 * @author admin
 */
@Service
public class UtilServiceImpl implements UtilService {

    @Autowired
    private ArticleReposity articleReposity;

    @Value("${upload.base.url}")
    private String baseUrl;

    @Value("${upload.image.path}")
    private String imagePath;
    /**
     * 上传图片接口
     *
     * @param file
     * @return
     */
    @Override
    public Map<String, Object> uploadImg(MultipartFile file) {
        Map<String, Object> returnMap = new HashMap<>();
        String uuidUrl = UUID.randomUUID().toString();
        String path = baseUrl + imagePath + uuidUrl;
        String savePath = imagePath + uuidUrl;
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
        String rpath = savePath + "/" + fileName;
        returnMap.put("location", rpath);
        return returnMap;

    }


    @Override
    public Map<String, String> packageFile(ArticleForm form) {

        List<Article> userList = articleReposity.getByUserId(form.getUserId());
        //html主路径文件地址
        String htmlPath = Constant.FILE_PATH + "htmlfile/";
        //目标文件夹位置
        String dirPath = FileUtils.generateHtml(userList, htmlPath);
        //生成Zip存放地址
        String packagePath = Constant.FILE_PATH + "package/";
        //文件名
        String fileName = form.getUserId() + ".zip";
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put(Param.PACKAGE_PATH, packagePath);
        returnMap.put(Param.FILE_NAME, fileName);
        //调用FileToZip接口生成压缩包
        FileUtils.fileToZip(dirPath, packagePath, fileName);
        FileUtils.deleteFolder(dirPath);
        return returnMap;
    }
}
