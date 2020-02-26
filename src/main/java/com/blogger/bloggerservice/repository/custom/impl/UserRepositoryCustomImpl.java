package com.blogger.bloggerservice.repository.custom.impl;

import com.blogger.bloggerservice.repository.common.RepositoryUtil;
import com.blogger.bloggerservice.repository.custom.UserReposityCustom;
import com.blogger.bloggerservice.repository.custom.WordReposityCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
@Repository
public class UserRepositoryCustomImpl implements UserReposityCustom {

    @Autowired
    private RepositoryUtil repositoryUtil;


    @Override
    public List<Map<String, Object>> findByUserId(Integer userId) {
        String sql = "SELECT id AS id,avatar_url AS avatarUrl,login_name AS loginName,user_name AS userName," +
                "user_email AS userEmail,user_mobile as userMobile,user_gender as userGender,user_word_number as userWordNumber," +
                "user_concern as userConcern,user_like as userLike,is_admin as isAdmin," +
                "created_at as createdAt FROM tb_user " +
                "WHERE id = ?";
        List<Object> objList = new ArrayList<>();
        objList.add(userId);
        List<Map<String, Object>> list = repositoryUtil.queryForMap(sql, objList.toArray());
        return list;
    }

    @Override
    public List<Map<String, Object>> findByIdIn(String userConcern) {
        if (StringUtils.isEmpty(userConcern)) {
            return new ArrayList<>();
        }
        String sql = "SELECT id AS id,avatar_url AS avatarUrl,login_name AS loginName,user_name AS userName," +
                "user_email AS userEmail,user_mobile as userMobile,user_gender as userGender,user_word_number as userWordNumber," +
                "user_concern as userConcern,user_like as userLike,is_admin as isAdmin," +
                "created_at as createdAt FROM tb_user " +
                "WHERE id in ("+ userConcern + ")";
        List<Map<String, Object>> mapList = repositoryUtil.queryForMap(sql, null);
        if (CollectionUtils.isEmpty(mapList)) {
            return new ArrayList<>();
        }
        return mapList;
    }

    @Override
    public List<Map<String, Object>> findByIdNotIn(String userIdString, Integer currentIndex, Integer pageSize) {
        String sql = "SELECT id AS id,avatar_url AS avatarUrl,login_name AS loginName,user_name AS userName," +
                "user_email AS userEmail,user_mobile as userMobile,user_gender as userGender,user_word_number as userWordNumber," +
                "user_concern as userConcern,user_like as userLike,is_admin as isAdmin," +
                "created_at as createdAt FROM tb_user ";

        if (!StringUtils.isEmpty(userIdString)) {
            sql += " WHERE id not in ("+ userIdString + ") ";
        }
        sql += " limit " + currentIndex + "," + pageSize;
        return repositoryUtil.queryForMap(sql, null);
    }
}
