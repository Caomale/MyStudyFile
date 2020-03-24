package com.jiaron.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.jiaron.mall.mbg.mapper.PmsBrandMapper;
import com.jiaron.mall.mbg.model.PmsBrand;
import com.jiaron.mall.mbg.model.PmsBrandExample;
import com.jiaron.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @author caoXB
 * @date 2020/3/13 18:48
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;


    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int insertBrand(PmsBrand brand) {
        return pmsBrandMapper.insertSelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateBrand(PmsBrand brand) {
        return pmsBrandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public PmsBrand selectByIdBrand(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> selectPageBrand(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }
}
