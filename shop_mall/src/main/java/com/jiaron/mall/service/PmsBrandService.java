package com.jiaron.mall.service;

import com.jiaron.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * 描述:
 *
 * @author caoXB
 * @date 2020/3/13 17:12
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int insertBrand(PmsBrand brand);

    int deleteBrand(Long id);

    int updateBrand(PmsBrand brand);

    PmsBrand selectByIdBrand(Long id);

    List<PmsBrand> selectPageBrand(Integer pageNum, Integer pageSize);
}
