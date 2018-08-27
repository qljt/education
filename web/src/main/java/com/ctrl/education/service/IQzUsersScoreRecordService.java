package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzUsersScoreRecord;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户积分记录 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
public interface IQzUsersScoreRecordService extends IService<QzUsersScoreRecord> {

    Result getList(Map<String, Object> map);
}
