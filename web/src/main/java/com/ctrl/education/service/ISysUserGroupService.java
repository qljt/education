package com.ctrl.education.service;

import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysUserGroup;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-07-31
 */
public interface ISysUserGroupService extends IService<SysUserGroup> {
    boolean setUserGroup(String userId, String GroupId);

    List<SysUserGroup> selectGroupByUseryId(String userId);

    List<ZTreeNode> groupTreeListByUserId(String userId);

    Result getList(Map<String,Object> map);

    List getListByGroupId(String groupId);

    List<Map<String,Object>> getNotInGroupList(String groupId);

    Result add(SysUserGroup sysUserGroup);

    Result remove(String id);
}
