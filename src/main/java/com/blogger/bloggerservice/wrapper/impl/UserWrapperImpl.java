package com.blogger.bloggerservice.wrapper.impl;

import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.exception.RespException;
import com.blogger.bloggerservice.model.User;
import com.blogger.bloggerservice.repository.UserRepository;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.wrapper.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 用户辅助方法
 */
@Component
public class UserWrapperImpl implements UserWrapper {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserInfo(String loginName, String userPassword) throws RespException {
        User user = userRepository.findByLoginNameAndUserPassword(loginName, userPassword);
        if (user == null) {
            throw new RespException(ResponseEnums.ERROR_SEV_USER_LOGIN);
        }
        return user;
    }

    @Override
    public User getUserInfo(String loginName) throws RespException {
        User user = userRepository.findByLoginName(loginName);
        if (user == null) {
            throw new RespException(ResponseEnums.ERROR_SEV_USER_LOGIN);
        }
        return user;
    }

    @Override
    public User getUserInfo(Integer userId) throws RespException {
        Optional<User> user = userRepository.findById(userId);
        if (user == null) {
            throw new RespException(ResponseEnums.ERROR_SEV_USER_LOGIN);
        }
        return user.get();
    }
}
