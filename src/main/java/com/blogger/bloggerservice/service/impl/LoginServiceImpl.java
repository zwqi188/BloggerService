package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.form.LoginForm;
import com.blogger.bloggerservice.model.Master;
import com.blogger.bloggerservice.repository.MasterRepository;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private MasterRepository masterRepository;

    @Override
    public ResultVo login(LoginForm loginForm) {
        Master master = masterRepository.findByLoginNameAndMasterPassword(loginForm.getUsername(), loginForm.getPassword());
        if(master != null) {
            ResultVo resultVo = ResultVo.success();
            resultVo.setData(master);
            return resultVo;
        }
        return new ResultVo(ResponseEnums.ERROR_LOGIN_FAIL);
    }
}
