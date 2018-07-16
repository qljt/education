package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysDict;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统字典表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-07-15
 */
public interface ISysDictService extends IService<SysDict> {

    Result getTreee();

    List<Map<String,Object>> getList(Map<String, Object> param);

    Result save(SysDict sysDict);

    Result modify(SysDict sysDict);

    Result remove(String id);
}
