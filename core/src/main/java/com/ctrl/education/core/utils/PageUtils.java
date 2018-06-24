package com.ctrl.education.core.utils;

import com.baomidou.mybatisplus.plugins.Page;

import java.io.Serializable;
import java.util.List;

/**
 * com.aloha.app.core.utils
 *
 * @author zgl
 * @name PageUtils
 * @description
 * @date 2018-02-28 13:59
 */
public class PageUtils implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     *  总记录数
     * */
    private long totalCount;
    /**
     *  每页记录数
     * */
    private int pageSize;
    /**
     *  总页数
     * */
    private long totalPage;
    /**
     *  当前页数
     * */
    private int currPage;
    /**
     *  列表数据
     * */
    private List<?> list;

    /**
     * 分页
     * @param list        列表数据
     * @param totalCount  总记录数
     * @param pageSize    每页记录数
     * @param currPage    当前页数
     */
    public PageUtils(List<?> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
    }

    /**
     * 分页
     */
    public PageUtils(Page<?> page) {
        this.list = page.getRecords();
        this.totalCount = page.getTotal();
        this.pageSize = page.getSize();
        this.currPage = page.getCurrent();
        this.totalPage = page.getPages();
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    /**
     * 为兼容layui表格的数据格式而存在的方法。
     * */
    public Result toLayTableResult(){
        return Result.ok()
                .put("count", this.getTotalCount())
                .put("data", this.getList());
    }
}
