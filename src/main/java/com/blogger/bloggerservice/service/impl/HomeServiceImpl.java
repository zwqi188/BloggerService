package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.model.User;
import com.blogger.bloggerservice.repository.HomeRepository;
import com.blogger.bloggerservice.response.Response;
import com.blogger.bloggerservice.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public Response getUser() {
        Response response = Response.success();
        response.setData(homeRepository.findAll());
        return response;
    }
}
