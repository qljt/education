package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzAppInterfaceLog;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 接口访问日志 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
public interface IQzAppInterfaceLogService extends IService<QzAppInterfaceLog> {

    Result getList(Map<String, Object> map);
}
