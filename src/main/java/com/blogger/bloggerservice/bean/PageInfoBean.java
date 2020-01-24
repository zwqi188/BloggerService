package com.blogger.bloggerservice.bean;

/**
 * 分页页码处理bean
 */
public class PageInfoBean {

    private Integer pageIndex;
    /**
     * 当前页
     */
    private Integer currentRow;

    /**
     * 页面大小
     */
    private Integer pageSize;

    public PageInfoBean() {

    }

    public PageInfoBean(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        if (pageIndex <= 1) {
            this.currentRow = 0;
        } else {
            this.currentRow = (pageIndex - 1) * pageSize;
        }
        this.pageSize = pageSize;
    }


    public Integer getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(Integer currentRow) {
        this.currentRow = currentRow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }
}
