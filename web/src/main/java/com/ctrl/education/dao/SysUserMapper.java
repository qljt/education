package com.ctrl.education.dao;

import com.ctrl.education.dto.SysUserDto;
import com.ctrl.education.dto.SysUserOfficeDto;
import com.ctrl.education.model.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户表 Mapper 接口
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<Map<String,Object>> getList(Map<String,Object> map);

    List<SysUserOfficeDto> selectUserOfficeById(String id);
}
