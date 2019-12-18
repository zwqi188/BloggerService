package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.repository.ArticleTypeRepository;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin
 */
@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    @Override
    public ResultVo queryMenuList() {
        ResultVo response = ResultVo.success();
        response.setData(articleTypeRepository.findAll());
        return response;
    }
}
