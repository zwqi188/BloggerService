package com.blogger.bloggerservice.repository.custom.impl;

import com.blogger.bloggerservice.repository.common.RepositoryUtil;
import com.blogger.bloggerservice.repository.custom.ArticleReposityCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
@Repository
public class ArticleReposityCustomImpl implements ArticleReposityCustom {

    @Autowired
    private RepositoryUtil repositoryUtil;

    @Override
    public List<Map<String, Object>> findArticleList(Integer pageIndex, Integer pageSize) {
        String sql = "select id,article_pic as articlePic,article_title as articleTitle,article_desc " +
                "as articleDesc,article_count as articleCount,article_info as articleInfo,article_like " +
                "as articleLike,article_replay as articleReplay,user_id as userId,user_name as userName," +
                "created_at as createdAt from tb_article limit ?,?";
        List<Object> objList = new ArrayList<>();
        objList.add(pageIndex);
        objList.add(pageSize);
        List<Map<String, Object>> list = repositoryUtil.queryForMap(sql, objList.toArray());
        return list;
    }
}
