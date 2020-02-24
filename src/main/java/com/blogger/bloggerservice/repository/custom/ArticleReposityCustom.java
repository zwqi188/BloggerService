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

    /**
     * 通过关注列表获取文章
     * @param currentPage
     * @param pageSize
     * @param userConcern
     * @return
     */
    List<Map<String, Object>> findConcernArticleList(Integer currentPage, Integer pageSize, String userConcern);
}
