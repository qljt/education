package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysUserOffice;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 单位人员关联表 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-03
 */
public interface ISysUserOfficeService extends IService<SysUserOffice> {

    Result getList(Map<String, Object> map);
}
