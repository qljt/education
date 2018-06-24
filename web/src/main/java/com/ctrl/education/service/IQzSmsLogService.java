package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzSmsLog;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 短信记录表 服务类
 * </p>
 *
 * @author liyang
 * @since 2018-06-20
 */
public interface IQzSmsLogService extends IService<QzSmsLog> {

    Result getList(Map<String,Object> map);
}
