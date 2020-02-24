package com.blogger.bloggerservice.service;

import com.blogger.bloggerservice.form.ArticleForm;
import com.blogger.bloggerservice.response.ResultVo;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * @author admin
 */
public interface UtilService {

    /**
     * 上传图片sevice
     * @param file
     * @return
     */
    Map<String, Object> uploadImg(MultipartFile file);


    Map<String, String> packageFile(ArticleForm form) throws IOException;
}
