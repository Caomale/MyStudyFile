package com.jiaron.mall.service;

import com.jiaron.mall.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * 描述: mongodb业务操作接口类
 *
 * @author caoXB
 * @date 2020/3/16 19:04
 */
public interface MemberReadHistoryService {
    /**
     * 生成浏览记录
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     */
    int delete(List<String> ids);

    /**
     * 获取用户浏览历史记录
     */
    List<MemberReadHistory> list(Long memberId);
}
