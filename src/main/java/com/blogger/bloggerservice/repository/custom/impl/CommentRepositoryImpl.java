package com.blogger.bloggerservice.repository.custom.impl;

import com.blogger.bloggerservice.repository.custom.CommentReposityCustom;
import com.blogger.bloggerservice.repository.common.RepositoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
@Repository
public class CommentRepositoryImpl implements CommentReposityCustom {

    @Autowired
    private RepositoryUtil repositoryUtil;

    @Override
    public List<Map<String, Object>> getCommentByArticleId(Integer articleId) {
        String sql = "select a.avatar_url as avatarUrl, a.login_name as userName, b.created_at as createdAt, " +
                " b.review_content as reviewContent from tb_user a,tb_comment b where a.id = b.master_id and b.article_id  = ?";
        List<Object> objList = new ArrayList<>();
        objList.add(articleId);
        List<Map<String, Object>> list = repositoryUtil.queryForMap(sql, objList.toArray());
        return list;
    }
}
