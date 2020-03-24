package com.jiaron.mall.common;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 描述: 公共分页数据结果类
 *
 * @author caoXB
 * @date 2020/3/13 18:09
 */
public class PageDataResult<T> {
    // 当前页码
    private Integer pageNum;
    // 总页数
    private Integer pageSize;
    // 总条数
    private Integer totalPage;
    // 单页条数
    private Long total;
    // 数据集合
    private List<T> list;

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> PageDataResult<T> restPage(List<T> list) {
        PageDataResult<T> result = new PageDataResult<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
