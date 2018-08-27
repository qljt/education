package com.ctrl.education.service;

import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysDictType;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 系统字典表 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-07-21
 */
public interface ISysDictTypeService extends IService<SysDictType> {
    PageUtils queryPage(Map<String, Object> params);

    boolean hasName(Integer id, String name);

    Result save(SysDictType sysDictType);

    Result remove(Integer id);

    Result modify(SysDictType sysDictType);
}
