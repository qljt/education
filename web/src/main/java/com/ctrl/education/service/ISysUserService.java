package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dto.SysUserDto;
import com.ctrl.education.model.SysUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
public interface ISysUserService extends IService<SysUser> {

    Result getList(Map<String,Object> map);

    Result save(SysUser sysUser);

    Result modify(SysUser sysUser);

    Result remove(String id);

    Result getSysUser(String id);
}
