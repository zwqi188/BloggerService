package com.blogger.bloggerservice.repository.custom;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
public interface UserReposityCustom {

    List<Map<String, Object>> findByUserId(Integer userId);

    /**
     * 查询id在一定范围内的用户
     * @param userConcern
     * @return
     */
    List<Map<String, Object>> findByIdIn(String userConcern);

    /**
     * 查询id不在范围内的用户
     * @param userIdString
     * @param currentIndex
     * @param pageSize
     * @return
     */
    List<Map<String, Object>> findByIdNotIn(String userIdString, Integer currentIndex, Integer pageSize);
}
