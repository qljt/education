package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysLog;

import java.util.Map;

/**
 * <p>
 * 系统日志 服务类
 * </p>
 *
 * @author liyang
 * @since 2018-06-03
 */
public interface ISysLogService extends IService<SysLog> {

    Result getList(Map<String, Object> map);
}
