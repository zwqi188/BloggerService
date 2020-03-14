package com.blogger.bloggerservice.aspect;

import com.blogger.bloggerservice.constant.Param;
import com.blogger.bloggerservice.form.BaseForm;
import com.blogger.bloggerservice.model.User;
import com.blogger.bloggerservice.repository.UserRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author admin
 */
@Aspect
@Component
public class UserInfoAspect {

    @Autowired
    private UserRepository userRepository;
    /**
     * 通过token获取用户信息
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(NeedCheckLogin)))")
    public Object checklogin (ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();
        for (Object arg: args) {
            if (!(arg instanceof BaseForm)) {
                continue;
            }
            HttpServletRequest request =
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader(Param.TOKEN);
            HttpSession session = request.getSession();
            Integer userId = (Integer) session.getAttribute(token);
            System.out.println("token " + token + "  获取丨userId:" + userId);
            if (userId != null) {
                User user = userRepository.findByUserId(userId);
                BaseForm baseForm = (BaseForm) arg;
                baseForm.setUserId(user.getId());
                baseForm.setAvatarUrl(user.getAvatarUrl());
                baseForm.setUserName(user.getUserName());
                baseForm.setLoginName(user.getLoginName());
                baseForm.setUserGender(user.getUserGender());
                baseForm.setUserEmail(user.getUserEmail());
                baseForm.setUserMobile(user.getUserMobile());
                baseForm.setUserLike(user.getUserLike());
                baseForm.setUserWordNumber(user.getUserWordNumber());
                baseForm.setIsAdmin(user.getIsAdmin());
                baseForm.setUserConcern(user.getUserConcern());
                baseForm.setCreatedAt(user.getCreatedAt());
                baseForm.setUpdatedAt(user.getUpdatedAt());
            }
        }
        return joinPoint.proceed();
    }

}
