package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.model.SysDictType;

import java.util.Map;

/**
 * <p>
 * 系统字典表 服务类
 * </p>
 *
 * @since 2018-06-03
 */
public interface ISysDictTypeService extends IService<SysDictType> {
    PageUtils queryPage(Map<String, Object> params);

    boolean hasName(Integer id, String name);

}
