package com.blogger.bloggerservice.form;

import javax.validation.constraints.NotNull;

/**
 * @author admin
 */
public class QueryForm {

    @NotNull(message = "id不能为空", groups = {Query.class})
    private String id;

    @NotNull(message = "name不能为空", groups = {Query.class})
    private String name;

    public interface Query {}
}
