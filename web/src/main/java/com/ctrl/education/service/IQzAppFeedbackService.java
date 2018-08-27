package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzAppFeedback;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 系统反馈 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
public interface IQzAppFeedbackService extends IService<QzAppFeedback> {

    Result getList(Map<String, Object> map);
}
