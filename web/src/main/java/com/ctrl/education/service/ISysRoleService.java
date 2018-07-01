package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysRole;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
public interface ISysRoleService extends IService<SysRole> {

    Result add(SysRole sysRole);

    Result modify(SysRole sysRole);

    Result tree();

    Result remove(String id);
}
