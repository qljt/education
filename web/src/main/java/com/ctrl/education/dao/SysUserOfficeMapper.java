package com.ctrl.education.dao;

import com.ctrl.education.model.SysUserOffice;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 单位人员关联表 Mapper 接口
 * </p>
 *
 * @author ctrl
 * @since 2018-08-03
 */
public interface SysUserOfficeMapper extends BaseMapper<SysUserOffice> {

    List<Map<String, Object>> getList(Map<String, Object> map);
}
