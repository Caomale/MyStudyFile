package com.jiaron.mall.service;

import com.jiaron.mall.mbg.model.UmsAdmin;
import com.jiaron.mall.mbg.model.UmsPermission;

import java.util.List;

/**
 * 描述:
 *
 * @author caoXB
 * @date 2020/3/14 18:50
 */
public interface UmsAdminService {

    UmsAdmin register(UmsAdmin umsAdminParam);

    String login(String username, String password);

    UmsAdmin getAdminByUsername(String username);

    List<UmsPermission> getPermissionList(Long id);
}
