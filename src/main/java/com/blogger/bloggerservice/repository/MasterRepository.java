package com.blogger.bloggerservice.repository;

import com.blogger.bloggerservice.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author admin
 */
public interface MasterRepository extends JpaRepository<Master, Integer> {

    /**
     * 通过登录名与密码登录
     * @param loginName
     * @param masterPassword
     * @return
     */
    Master findByLoginNameAndMasterPassword(String loginName, String masterPassword);
}
