package com.blogger.bloggerservice.repository.custom;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
public interface UserReposityCustom {

    List<Map<String, Object>> findByUserId(Integer userId);
}
