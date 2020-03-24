package com.jiaron.mall.service;

import com.jiaron.mall.common.CommonResult;

/**
 * 描述:
 *
 * @author caoXB
 * @date 2020/3/14 17:38
 */
public interface UmsMemberService {

    CommonResult generateAuthCode(String phone);

    CommonResult verifyAuthCode(String phone, String authCode);

}
