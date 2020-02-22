package com.blogger.bloggerservice.repository.custom.impl;

import com.blogger.bloggerservice.repository.custom.WordReposityCustom;
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
public class WordRepositoryCustomImpl implements WordReposityCustom {

    @Autowired
    private RepositoryUtil repositoryUtil;

    @Override
    public List<Map<String, Object>> findAllWord() {
        String sql = "select a.created_at as createdAt, a.word_content " +
                "as wordContent,b.avatar_url as avatarUrl ,b.login_name as " +
                "loginName from tb_word a,tb_user b where a.master_id = b.id";
        List<Object> objList = new ArrayList<>();
        List<Map<String, Object>> list = repositoryUtil.queryForMap(sql, objList.toArray());
        return list;
    }
}
