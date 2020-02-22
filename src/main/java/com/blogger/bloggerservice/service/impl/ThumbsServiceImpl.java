package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.bean.PageInfoBean;
import com.blogger.bloggerservice.constant.Param;
import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.form.ArticleForm;
import com.blogger.bloggerservice.form.ThumbsForm;
import com.blogger.bloggerservice.model.Article;
import com.blogger.bloggerservice.model.User;
import com.blogger.bloggerservice.repository.ArticleReposity;
import com.blogger.bloggerservice.repository.ArticleTypeRepository;
import com.blogger.bloggerservice.repository.UserRepository;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.ArticleService;
import com.blogger.bloggerservice.service.ThumbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
@Service
public class ThumbsServiceImpl implements ThumbsService {

    @Autowired
    private ArticleReposity articleReposity;

    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    @Override
    public ResultVo thumbsUp(ThumbsForm thumbs) {
        User user = userRepository.findByUserId(thumbs.getUserId());
        if(user == null) {
            return new ResultVo(ResponseEnums.ERROR_SEV_USER_NOT_LOGIN);
        }
        try {
            articleReposity.thumbsUpById(thumbs.getArticleId());
        } catch (Exception ex) {
            return new ResultVo(ResponseEnums.ERROR_SAVE_TO_DATEBASE);
        }
        return ResultVo.success();
    }
}
