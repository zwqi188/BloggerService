package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.repository.HomeRepository;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public ResultVo getUser() {
        ResultVo response = ResultVo.success();
        response.setData(homeRepository.findAll());
        return response;
    }
}
