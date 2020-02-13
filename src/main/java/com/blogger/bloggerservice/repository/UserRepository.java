package com.blogger.bloggerservice.repository;

import com.blogger.bloggerservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author admin
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 通过登录名与密码登录
     * @param loginName
     * @param userPassword
     * @return
     */
    User findByLoginNameAndUserPassword(String loginName, String userPassword);

    /**
     * 通过登录名查找用户信息
     * @param loginName
     * @return
     */
    User findByLoginName(String loginName);

    /**
     * 通过userId获取用户信息
     * @param userId
     * @return
     */
    @Query(value = "select * from tb_user where  id=:userId", nativeQuery = true)
    User findByUserId(@Param("userId") Integer userId);

    /**
     * 同时通过userId获取用户信息
     * @param userIdList
     * @return
     */
    List<User> findByIdIn(Integer[] userIdList);

    /**
     * 查询前5的数据
     * @param
     * @return
     */
    @Query(value = "select * from tb_user limit 5", nativeQuery = true)
    List<User> findByTop5();
}
