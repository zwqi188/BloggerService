package com.blogger.bloggerservice.repository.custom;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
public interface ArticleReposityCustom {

    /**
     * 获取文章列表
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<Map<String, Object>> findArticleList(Integer pageIndex, Integer pageSize);
}
