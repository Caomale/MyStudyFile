package com.jiaron.mall.dao;

import com.jiaron.mall.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述: 后台用户与角色管理自定义Dao
 *
 * @author caoXB
 * @date 2020/3/14 19:38
 */
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
