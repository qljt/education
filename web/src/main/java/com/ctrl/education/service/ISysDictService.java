package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.dto.SysDictDto;
import com.ctrl.education.model.SysDict;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统字典表 服务类
 * </p>
 *
 * @since 2018-06-03
 */
public interface ISysDictService extends IService<SysDict> {
    PageUtils queryPage(Map<String, Object> params);

    boolean hasValue(Integer id, Integer typeId, String value);

    List<SysDictDto> getDictsByTypeName(String typeName);

}
