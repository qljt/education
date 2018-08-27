package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzForumGroupUsers;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 论坛小组成员 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-17
 */
public interface IQzForumGroupUsersService extends IService<QzForumGroupUsers> {

    Result getQzusersByGroup(Map<String, Object> param);
}
