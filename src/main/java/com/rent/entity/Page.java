package com.rent.entity;

import java.util.List;

/**
 * 分页类
 */
public class Page<T> {
    private int pageSize;   //每页显示的数量
    private int currentPage;  //当前页数
    private int  totalPage;    //总页数
    private int totalCount;    //总条数
    private List<T> pageList;   //当前页的集合


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if(pageSize>0){
            this.pageSize = pageSize;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if(currentPage>=0){
            this.currentPage = currentPage;
        }
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage=totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if(totalCount>=0) {
            this.totalCount = totalCount;
            this.totalPage = this.totalCount % this.pageSize == 0 ? (this.totalCount / this.pageSize) : (this.totalCount / this.pageSize + 1);
        }
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }
}
