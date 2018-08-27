package com.ctrl.education.dao;

import com.ctrl.education.model.QzForumGroup;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 论坛小组 Mapper 接口
 * </p>
 *
 * @author ctrl
 * @since 2018-08-17
 */
public interface QzForumGroupMapper extends BaseMapper<QzForumGroup> {

    List<Map<String, Object>> getLists(Map<String, Object> param);

}
