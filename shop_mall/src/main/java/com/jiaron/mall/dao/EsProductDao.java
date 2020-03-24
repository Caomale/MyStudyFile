package com.jiaron.mall.dao;

import com.jiaron.mall.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述:
 *
 * @author caoXB
 * @date 2020/3/16 16:52
 */
public interface EsProductDao {

    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
