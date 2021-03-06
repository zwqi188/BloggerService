package com.blogger.bloggerservice.bean;

/**
 * 分页页码处理bean
 */
public class PageInfoBean {

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 当前索引
     */
    private Integer currentIndex;

    public PageInfoBean() {

    }

    public PageInfoBean(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        if (currentPage <= 1) {
            this.currentPage = 0;
            this.currentIndex = 0;
        } else {
            this.currentIndex = (currentPage - 1) * pageSize;
        }
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
    }
}
