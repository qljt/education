package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzTrain;
import com.ctrl.education.model.QzUsers;

import java.util.Map;

/**
 * <p>
 * 培训任务列表 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
public interface IQzTrainService extends IService<QzTrain> {
    Result list(Map<String, Object> map);
}
