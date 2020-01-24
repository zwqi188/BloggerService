package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.constant.Param;
import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.exception.RespException;
import com.blogger.bloggerservice.form.UserForm;
import com.blogger.bloggerservice.model.User;
import com.blogger.bloggerservice.repository.UserRepository;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.UserService;
import com.blogger.bloggerservice.utils.ComUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Date;

/**
 * 用户service
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 用户注册
     * @param userForm
     * @return
     */
    @Override
    @Transactional
    public ResultVo register(UserForm userForm, HttpServletRequest request) throws RespException {
        String random = ComUtils.getSession(request, Param.RAND_CHECK_CODE);
        if(!userForm.getVarifyCode().equals(random)) {
            return new ResultVo(ResponseEnums.ERROR_SEV_VARIFY_CODE);
        }
        User user = null;
        user = userRepository.findByLoginName(userForm.getUserName());
        if(user != null) {
            return new ResultVo(ResponseEnums.ERROR_SEV_USER_EXIST);
        }
        ResultVo resultVo = ResultVo.success();
        user = new User();
        user.setUserName(userForm.getUserName());
        user.setLoginName(userForm.getUserName());
        user.setUserPassword(userForm.getUserPassword());
        user.setCreatedAt(new Date());
        User saveUser = userRepository.save(user);
        resultVo.setData(saveUser.getId());
        return resultVo;
    }

    /**
     * 用户登录接口
     * @param userForm
     * @param request
     * @return
     * @throws RespException
     */
    @Override
    @Transactional
    public ResultVo login(UserForm userForm, HttpServletRequest request) throws RespException {
        String random = ComUtils.getSession(request, Param.RAND_CHECK_CODE);
        if(!userForm.getVarifyCode().equals(random)) {
            return new ResultVo(ResponseEnums.ERROR_SEV_VARIFY_CODE);
        }
        ResultVo resultVo = ResultVo.success();
        User user = userRepository.findByLoginNameAndUserPassword(userForm.getUserName(), userForm.getUserPassword());
        if (user == null) {
            return new ResultVo(ResponseEnums.ERROR_SEV_USER_NOT_EXIST);
        }
        resultVo.setData(user.getId());
        //清除用户验证码session数据
        ComUtils.cleanSession(request, Param.RAND_CHECK_CODE);
        return resultVo;
    }

    @Override
    public ResultVo loginOut(UserForm userForm, HttpServletRequest request) throws RespException {
        ComUtils.cleanSession(request, Param.RAND_CHECK_CODE);
        return ResultVo.success();
    }
}