package com.jiaron.mall.controller;

import com.jiaron.mall.common.CommonResult;
import com.jiaron.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 描述: 会员管理控制类
 *
 * @author caoXB
 * @date 2020/3/14 17:34
 */
@Api(tags = "UmsMemberController", description = "会员管理")
@RestController
@RequestMapping("member")
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @GetMapping("/getAuthCode")
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation("校验验证码是否正确")
    @GetMapping("/verifyAuthCode")
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return umsMemberService.verifyAuthCode(telephone,authCode);
    }
}
