package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.model.User;
import com.blogger.bloggerservice.repository.HomeRepository;
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
    public List<User> getUser() {
        return homeRepository.findAll();
    }
}
