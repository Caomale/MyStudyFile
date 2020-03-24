package com.jiaron.mall.nosql.elasticsearch.repository;

import com.jiaron.mall.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 描述: es 商品操作类
 *
 * @author caoXB
 * @date 2020/3/16 16:56
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {
    /**
     * 搜索查询
     * @param name              商品名称
     * @param subTitle          商品标题
     * @param keywords          商品关键字
     * @param page              分页信息
     * @return
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);
}
