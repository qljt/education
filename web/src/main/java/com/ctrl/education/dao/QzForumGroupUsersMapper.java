package com.ctrl.education.dao;

import com.ctrl.education.model.QzForumGroupUsers;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 论坛小组成员 Mapper 接口
 * </p>
 *
 * @author ctrl
 * @since 2018-08-17
 */
public interface QzForumGroupUsersMapper extends BaseMapper<QzForumGroupUsers> {

    List<Map<String, Object>> getQzusersByGroup(Map<String, Object> param);
}
