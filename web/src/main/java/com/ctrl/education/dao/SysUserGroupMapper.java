package com.ctrl.education.dao;

import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.model.SysUserGroup;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ctrl
 * @since 2018-07-31
 */
public interface SysUserGroupMapper extends BaseMapper<SysUserGroup> {

    List<ZTreeNode> groupTreeListByUserId(String userId);

    List<Map<String,Object>> getList(Map<String,Object> map);

    List getListByGroupId(String groupId);

    List<Map<String,Object>> getNotInGroupList(String groupId);
}
