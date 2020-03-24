package com.jiaron.mall.controller;

import com.jiaron.mall.common.CommonResult;
import com.jiaron.mall.nosql.mongodb.document.MemberReadHistory;
import com.jiaron.mall.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述: 会员商品浏览记录管理控制类
 *
 * @author caoXB
 * @date 2020/3/16 19:06
 */
@Api(tags = "MemberReadHistoryController", description = "会员商品浏览记录管理")
@RequestMapping("member/readHistory")
@RestController
public class MemberReadHistoryController {
    @Autowired
    private MemberReadHistoryService memberReadHistoryService;

    @ApiOperation("创建浏览记录")
    @PostMapping("/create")
    public CommonResult create(@RequestBody MemberReadHistory memberReadHistory) {
        int count = memberReadHistoryService.create(memberReadHistory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除浏览记录")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam("ids") List<String> ids) {
        int count = memberReadHistoryService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("展示浏览记录")
    @GetMapping(value = "/list")
    public CommonResult<List<MemberReadHistory>> list(Long memberId) {
        List<MemberReadHistory> memberReadHistoryList = memberReadHistoryService.list(memberId);
        return CommonResult.success(memberReadHistoryList);
    }
}
