package com.jiaron.mall.controller;

import com.jiaron.mall.common.CommonResult;
import com.jiaron.mall.common.PageDataResult;
import com.jiaron.mall.nosql.elasticsearch.document.EsProduct;
import com.jiaron.mall.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述: ES 搜索商品
 *
 * @author caoXB
 * @date 2020/3/16 16:34
 */
@Api(tags = "EsProductController", description = "搜索商品管理")
@RestController
@RequestMapping("/esProduct")
public class EsProductController {
    @Autowired
    private EsProductService esProductService;

    @ApiOperation(value = "导入所有数据库中的商品到ES")
    @PostMapping("/importAll")
    public CommonResult<Integer> importAllList() {
        int count = esProductService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "根据id删除商品")
    @PostMapping("/delete/{id}")
    public CommonResult<Object> delete(@PathVariable Long id) {
        esProductService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id批量删除商品")
    @PostMapping("/delete/batch")
    public CommonResult<Object> delete(@RequestParam("ids") List<Long> ids) {
        esProductService.delete(ids);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据id创建商品")
    @PostMapping("/create/{id}")
    public CommonResult<EsProduct> create(@PathVariable Long id) {
        EsProduct esProduct = esProductService.create(id);
        if (esProduct != null) {
            return CommonResult.success(esProduct);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation(value = "简单搜索")
    @GetMapping("/search/simple")
    public CommonResult<PageDataResult<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                          @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                          @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsProduct> esProductPage = esProductService.search(keyword, pageNum, pageSize);
        return CommonResult.success(PageDataResult.restPage(esProductPage.getContent()));
    }

}
