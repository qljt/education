package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzUsers;
import com.ctrl.education.model.QzUsersScoreRecord;

import java.util.Map;

/**
 * <p>
 * 用户积分记录 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
public interface IQzUsersService extends IService<QzUsers> {
    Result selectUser(String departId);

    Result getUserById(String id);
}
