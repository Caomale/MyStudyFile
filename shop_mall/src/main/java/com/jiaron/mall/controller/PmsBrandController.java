package com.jiaron.mall.controller;

import com.jiaron.mall.common.CommonResult;
import com.jiaron.mall.common.PageDataResult;
import com.jiaron.mall.mbg.model.PmsBrand;
import com.jiaron.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述: 品牌管理控制类
 *
 * @author caoXB
 * @date 2020/3/13 18:01
 */
@Api(tags = "PmsBrandController", description = "商品品牌管理")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @Autowired
    private PmsBrandService pmsBrandService;

    @ApiOperation("获取所有品牌列表")
    @GetMapping("/getList")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    @ApiOperation("添加品牌")
    @PostMapping("/insert")
    @PreAuthorize("hasAuthority('pms:brand:create')")
    public CommonResult createBrand(PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = pmsBrandService.insertBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("删除指定id的品牌")
    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        int count = pmsBrandService.deleteBrand(id);
        if (count == 1) {
            LOGGER.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("修改指定id的品牌")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('pms:brand:update')")
    public CommonResult updateBrand(PmsBrand brand) {
        int count = pmsBrandService.updateBrand(brand);
        if (count == 1) {
            LOGGER.debug("updateBrand success :id={}", brand.getId());
            return CommonResult.success(null);
        } else {
            LOGGER.debug("updateBrand failed :id={}", brand.getId());
            return CommonResult.failed();
        }
    }

    @ApiOperation("查询指定id的品牌")
    @GetMapping("/select/{id}")
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult selectByIdBrand(@PathVariable("id") Long id) {
        PmsBrand brand = pmsBrandService.selectByIdBrand(id);
        if (!ObjectUtils.isEmpty(brand)) {
            LOGGER.debug("selectByIdBrand success :id={}", id);
            return CommonResult.success(brand);
        } else {
            LOGGER.debug("selectByIdBrand failed :id={}", id);
            return CommonResult.failed();
        }
    }

    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/listPage", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<PageDataResult<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1")
                                                        @ApiParam("页码") Integer pageNum,
                                                            @RequestParam(value = "pageSize", defaultValue = "4")
                                                        @ApiParam("每页数量") Integer pageSize) {
        List<PmsBrand> brandList = pmsBrandService.selectPageBrand(pageNum, pageSize);
        return CommonResult.success(PageDataResult.restPage(brandList));
    }



}
