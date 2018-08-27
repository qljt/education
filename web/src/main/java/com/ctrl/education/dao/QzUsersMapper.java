package com.ctrl.education.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ctrl.education.model.QzTeacher;
import com.ctrl.education.model.QzUsers;
import com.ctrl.education.model.SysDict;

import java.util.List;

/**
 * <p>
 * 教师表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2018-07-20
 */
public interface QzUsersMapper extends BaseMapper<QzUsers> {
    List<QzUsers> selectUsers(String partId);

    QzUsers getUserById(String id);
}
