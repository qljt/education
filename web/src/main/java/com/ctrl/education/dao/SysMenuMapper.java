package com.ctrl.education.dao;

import com.ctrl.education.core.node.MenuNode;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.model.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<ZTreeNode> menuTreeList();

    List<String> getMenuIdsByRoleId(String roleId);

    List<ZTreeNode> menuTreeListByMenuIds(List<String> menuIds);

    List<MenuNode> getMenusByRoleIds(List<String> roleIds);
}
