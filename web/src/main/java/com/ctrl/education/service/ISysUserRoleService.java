package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysUserRole;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-07-31
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    Result setRole(String id, String roleIds);
}
