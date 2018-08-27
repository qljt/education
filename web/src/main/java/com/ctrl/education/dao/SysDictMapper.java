package com.ctrl.education.dao;

import com.ctrl.education.dto.SysDictDto;
import com.ctrl.education.model.SysDict;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统字典表 Mapper 接口
 * </p>
 *
 * @author ctrl
 * @since 2018-07-21
 */
public interface SysDictMapper extends BaseMapper<SysDict> {

    List<SysDictDto> getDictsByTypeName(@Param("typeName") String typeName);

    List<SysDict> selectExamType();
}
