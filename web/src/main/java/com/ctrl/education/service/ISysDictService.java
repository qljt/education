package com.ctrl.education.service;

import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dto.SysDictDto;
import com.ctrl.education.model.SysDict;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统字典表 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-07-21
 */
public interface ISysDictService extends IService<SysDict> {
    PageUtils queryPage(Map<String, Object> params);

    boolean hasValue(Integer id, Integer typeId, String value);

    List<SysDictDto> getDictsByTypeName(String typeName);

    Result save(SysDict sysDict);

    Result modify(SysDict sysDict);

    Result remove(Integer id);

    Result selectExamType();
}
