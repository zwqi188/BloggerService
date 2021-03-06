package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.bean.PageInfoBean;
import com.blogger.bloggerservice.bean.RecommendUserBean;
import com.blogger.bloggerservice.constant.Constant;
import com.blogger.bloggerservice.constant.Param;
import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.exception.RespException;
import com.blogger.bloggerservice.form.RecommendForm;
import com.blogger.bloggerservice.form.UserForm;
import com.blogger.bloggerservice.model.User;
import com.blogger.bloggerservice.repository.UserRepository;
import com.blogger.bloggerservice.repository.custom.UserReposityCustom;
import com.blogger.bloggerservice.repository.custom.impl.UserRepositoryCustomImpl;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.UserService;
import com.blogger.bloggerservice.utils.ComUtils;
import com.blogger.bloggerservice.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.*;

/**
 * 用户service
 * @author admin
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserReposityCustom userReposityCustom;

    /**
     * 用户注册
     * @param userForm
     * @return
     */
    @Override
    @Transactional
    public ResultVo register(UserForm userForm, HttpServletRequest request) throws RespException {
        logger.info("开始验证session, [varifyCode] :" + userForm.getVarifyCode());
        String checkCode = ComUtils.getSession(request, Param.RAND_CHECK_CODE);
        if(!userForm.getVarifyCode().equals(checkCode)) {
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
        user.setIsAdmin(0);
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
        ResultVo resultVo = ResultVo.success();
        User user = userRepository.findByLoginNameAndUserPassword(userForm.getUserName(), userForm.getUserPassword());
        if (user == null) {
            return new ResultVo(ResponseEnums.ERROR_SEV_USER_LOGIN);
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

    /**
     * 获得推荐作者
     * 1、查询用户的关注信息
     * 2、将用户关注的人的作为推荐用户
     * @return
     */
    @Override
    public ResultVo getRecommendUser(RecommendForm form) {
        User queryUser = userRepository.findByUserId(form.getId());
        PageInfoBean pageInfoBean = new PageInfoBean(form.getIndex(), Constant.RECOMMEND_USER_NUMBER);
        ResultVo response = ResultVo.success();
        List<Map<String, Object>> returnList = new ArrayList<>();
        List<Integer> userIdList = null;
        if (queryUser != null) {
            userIdList = ComUtils.convertUserIdList(queryUser.getUserConcern());
            String userIdString = ComUtils.generateIdString(userIdList,
                    pageInfoBean.getCurrentIndex(), pageInfoBean.getPageSize());
            returnList = userReposityCustom.findByIdIn(userIdString);
            returnList = ComUtils.hasConcern(returnList, true);
            // 预防查询之后数据不够5条，重新设置索引，开始查询未关注
            pageInfoBean.setCurrentPage(0);
        }
        if (returnList.size() < Constant.RECOMMEND_USER_NUMBER) {
            String userIdString = null;
            if (userIdList != null) {
                userIdString = ComUtils.generateIdString(userIdList, 0, userIdList.size()) + ",";
            }
            if (form.getId() != null) {
                userIdString = (userIdString == null) ? "" : userIdString;
                userIdString += "'" + form.getId() + "'";
            }
            List<Map<String, Object>> userList = userReposityCustom.findByIdNotIn(userIdString,
                    pageInfoBean.getCurrentPage() * pageInfoBean.getPageSize(),
                    pageInfoBean.getPageSize());
            userList = ComUtils.hasConcern(userList, false);
            for(Map<String, Object> user : userList) {
                if (returnList.size() == Constant.RECOMMEND_USER_NUMBER) {
                    continue;
                }
                returnList.add(user);
            }
        }

        response.setData(returnList);
        return response;
    }

    @Override
    public ResultVo queryUser(UserForm user) {
        List<Map<String, Object>> userList = userReposityCustom.findByUserId(user.getUserId());
        if(userList.get(0) == null) {
            return new ResultVo(ResponseEnums.ERROR_SEV_USER_NOT_EXIST);
        }
        ResultVo response = ResultVo.success();
        response.setData(userList.get(0));
        return response;
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @Transactional
    @Override
    public ResultVo saveUser(UserForm user) {
        User queryUser = userRepository.findByUserId(user.getUserId());
        if(queryUser == null) {
            return new ResultVo(ResponseEnums.ERROR_SEV_USER_NOT_EXIST);
        }
        if (!StringUtils.isEmpty(user.getAvatarUrl())) {
            queryUser.setAvatarUrl(user.getAvatarUrl());
        }
        if (!StringUtils.isEmpty(user.getUserName())) {
            queryUser.setUserName(user.getUserName());
        }
        if (!StringUtils.isEmpty(user.getUserGender())) {
            queryUser.setUserGender(user.getUserGender());
        }
        if (!StringUtils.isEmpty(user.getUserMobile())) {
            queryUser.setUserMobile(user.getUserMobile());
        }
        if (!StringUtils.isEmpty(user.getUserEmail())) {
            queryUser.setUserEmail(user.getUserEmail());
        }
        try {
            userRepository.save(queryUser);
        } catch (Exception ex) {
            return new ResultVo(ResponseEnums.ERROR_SAVE_TO_DATEBASE);
        }
        return ResultVo.success();
    }

    @Override
    public ResultVo updatePassword(UserForm form) {
        User queryUser = userRepository.findByUserId(form.getUserId());
        if(queryUser == null) {
            return new ResultVo(ResponseEnums.ERROR_SEV_USER_NOT_EXIST);
        }
        if (!queryUser.getUserPassword().equals(form.getOrignPassword())) {
            return new ResultVo(ResponseEnums.ERROR_SEV_USER_PASSWORD);
        }
        queryUser.setUserPassword(form.getUserPassword());
        try {
            userRepository.save(queryUser);
        } catch (Exception ex) {
            return new ResultVo(ResponseEnums.ERROR_SAVE_TO_DATEBASE);
        }
        return ResultVo.success();
    }
}
