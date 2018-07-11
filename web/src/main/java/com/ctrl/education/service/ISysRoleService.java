package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dto.SysRoleDto;
import com.ctrl.education.model.SysRole;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

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

    Result setAuthority(String roleId, String ids);

    Result roleTreeListByUserId(String userId);

    Result getList(Map<String,Object> map);

    SysRoleDto selectByRoleId(String id);
}
