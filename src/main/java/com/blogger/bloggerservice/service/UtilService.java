package com.blogger.bloggerservice.service;

import org.springframework.web.multipart.MultipartFile;

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
}
