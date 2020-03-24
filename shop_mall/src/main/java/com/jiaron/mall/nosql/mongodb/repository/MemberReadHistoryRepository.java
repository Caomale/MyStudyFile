package com.jiaron.mall.nosql.mongodb.repository;

import com.jiaron.mall.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 描述: 会员 商品浏览历史 Repository类
 *
 * @author caoXB
 * @date 2020/3/16 19:03
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    /**
     * 根据会员id按时间倒序获取浏览记录
     * @param memberId 会员id
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
