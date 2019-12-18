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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public interface Query {}
}
