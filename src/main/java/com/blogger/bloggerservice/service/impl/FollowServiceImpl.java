package com.blogger.bloggerservice.service.impl;

import com.blogger.bloggerservice.constant.Constant;
import com.blogger.bloggerservice.enums.MessageTypeEnums;
import com.blogger.bloggerservice.enums.ResponseEnums;
import com.blogger.bloggerservice.form.FollowForm;
import com.blogger.bloggerservice.model.Message;
import com.blogger.bloggerservice.model.User;
import com.blogger.bloggerservice.repository.MessageRepository;
import com.blogger.bloggerservice.repository.UserRepository;
import com.blogger.bloggerservice.response.ResultVo;
import com.blogger.bloggerservice.service.FollowService;
import com.blogger.bloggerservice.utils.ComUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author admin
 */
@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    @Transactional
    public ResultVo follow(FollowForm form) {
        User user = userRepository.findByUserId(form.getUserId());
        if (user == null) {
            return new ResultVo(ResponseEnums.ERROR_SEV_USER_NOT_LOGIN);
        }
        Integer[] conrenList = ComUtils.convertConcernList(user.getUserConcern());
        user.setUserConcern(ComUtils.convertFollowList(ComUtils.follow(conrenList, form.getFollowId())));
        Message message = new Message();
        message.setSendId(user.getId());
        message.setSendName(user.getUserName());
        message.setMessageType(MessageTypeEnums.FOLLOW.getCode());
        message.setReceiverId(form.getFollowId());
        message.setReceiverName(form.getFollowName());
        message.setMessageContent(form.getFollowName() + MessageTypeEnums.FOLLOW.getName() + "了你");
        message.setHasRead(Constant.NOT_READ);
        message.setCreatedAt(new Date());
        try {
            userRepository.save(user);
            messageRepository.save(message);
        } catch (Exception e) {
            return new ResultVo(ResponseEnums.ERROR_SAVE_TO_DATEBASE);
        }
        return ResultVo.success();
    }

    @Override
    public ResultVo UnFollow(FollowForm form) {
        User user = userRepository.findByUserId(form.getUserId());
        if (user == null) {
            return new ResultVo(ResponseEnums.ERROR_SEV_USER_NOT_LOGIN);
        }
        Integer[] conrenList = ComUtils.convertConcernList(user.getUserConcern());
        user.setUserConcern(ComUtils.convertFollowList(ComUtils.unfollow(conrenList, form.getFollowId())));
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return new ResultVo(ResponseEnums.ERROR_SAVE_TO_DATEBASE);
        }
        return ResultVo.success();
    }

    /**
     * 查询我的关注列表
     * @param form
     * @return
     */
    @Override
    public ResultVo queryfollowByUserId(FollowForm form) {
        User user = userRepository.findByUserId(form.getUserId());
        if (user == null) {
            return new ResultVo(ResponseEnums.ERROR_SEV_USER_NOT_LOGIN);
        }
        Integer[] followList = ComUtils.convertConcernList(user.getUserConcern());
        List<User> userList = userRepository.findByIdIn(followList);
        ResultVo resultVo = ResultVo.success();
        resultVo.setData(userList);
        return resultVo;
    }
}
