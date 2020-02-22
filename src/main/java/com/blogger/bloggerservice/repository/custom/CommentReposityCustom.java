package com.blogger.bloggerservice.repository.custom;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
public interface CommentReposityCustom {

    List<Map<String, Object>> getCommentByArticleId(Integer articleId);
}
