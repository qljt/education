package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysLoginLog;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 登录日志 服务类
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
public interface ISysLoginLogService extends IService<SysLoginLog> {
    Result getList(Map<String, Object> param);
}
