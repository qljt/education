package com.ctrl.education.dao;

import com.ctrl.education.dto.SysDictDto;
import com.ctrl.education.model.SysDict;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 系统字典表 Mapper 接口
 * </p>
 *
 * @author liyang
 * @since 2018-06-03
 */
public interface SysDictMapper extends BaseMapper<SysDict> {

    List<SysDictDto> getDictsByTypeName(String typeName);
}
