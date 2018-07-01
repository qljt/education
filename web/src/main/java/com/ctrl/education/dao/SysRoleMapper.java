package com.ctrl.education.dao;

import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.model.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 获取ztree的节点列表
     */
    List<ZTreeNode> tree();
}
