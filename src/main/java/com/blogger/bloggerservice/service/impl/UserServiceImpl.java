package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.bean.RecommendUserBean;
import com.blogger.bloggerservice.constant.Constant;
import com.blogger.bloggerservice.constant.Param;
import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.exception.RespException;
import com.blogger.bloggerservice.form.UserForm;
import com.blogger.bloggerservice.model.User;
import com.blogger.bloggerservice.repository.UserRepository;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.UserService;
import com.blogger.bloggerservice.utils.ComUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 用户service
 * @author admin
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

    /**
     * 获得推荐作者
     * 1、查询用户的关注信息
     * 2、将用户关注的人的作为推荐用户
     * @return
     */
    @Override
    public ResultVo getRecommendUser(UserForm user) {
        User queryUser = userRepository.findByUserId(user.getUserId());
        ResultVo response = ResultVo.success();
        if(queryUser == null) {
            return new ResultVo(ResponseEnums.ERROR_SEV_USER_NOT_EXIST);
        }
        List<RecommendUserBean> recommendUserBeanList = new ArrayList<>();
        List<User> responseUser = new ArrayList<>();
        //可以拆分的页数
        Integer page = 0;
        //最后剩余的条数
        Integer last = 0;
        if(!StringUtils.isEmpty(queryUser.getUserConcern())) {
            Integer[] concernList = ComUtils.convertConcernList(queryUser.getUserConcern());
            Integer[] arrayCopy = null;
            page = concernList.length / Constant.RECOMMEND_USER_NUMBER;
            last = concernList.length % Constant.RECOMMEND_USER_NUMBER;
            // 索引小于页数或者同时满足索引等于页数并且余下的大于0
            Boolean needCopy = (user.getIndex() - 1) <= page
                    || (page.equals(user.getIndex() -1) && last > 0);
            if (needCopy) {
                Integer from = user.getIndex() == 1 ? 0: (user.getIndex() - 1 ) * Constant.RECOMMEND_USER_NUMBER - 1;
                arrayCopy = Arrays.copyOfRange(concernList,
                        from, Constant.RECOMMEND_USER_NUMBER);
            }
            if (arrayCopy != null) {
                responseUser = userRepository.findByIdIn(arrayCopy);
                for (User users: responseUser) {
                    RecommendUserBean recommendUserBean = new RecommendUserBean();
                    BeanUtils.copyProperties(users, recommendUserBean);
                    recommendUserBean.setHasConcern(true);
                    recommendUserBeanList.add(recommendUserBean);
                }
            }
        }
        if (responseUser.size() < Constant.RECOMMEND_USER_NUMBER) {
            Integer start = 0;
            Integer end = Constant.RECOMMEND_USER_NUMBER - responseUser.size();
            responseUser = userRepository.findByTopAndNoIn(
                    queryUser.getUserConcern(), start, end);
            for (User users: responseUser) {
                RecommendUserBean recommendUserBean = new RecommendUserBean();
                BeanUtils.copyProperties(users, recommendUserBean);
                recommendUserBean.setHasConcern(false);
                recommendUserBeanList.add(recommendUserBean);
            }
        }
        response.setData(recommendUserBeanList);
        return response;
    }
}
