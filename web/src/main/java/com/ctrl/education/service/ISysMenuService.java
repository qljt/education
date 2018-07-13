package com.ctrl.education.service;

import com.ctrl.education.core.node.MenuNode;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysMenu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<Map<String,Object>> getList(Map<String,Object> map);

    List<ZTreeNode> menuTreeList();

    List<String> getMenuIdsByRoleId(String roleId);

    List<ZTreeNode> menuTreeListByMenuIds(List<String> menuIds);

    Result save(SysMenu sysMenu);

    Result modify(SysMenu sysMenu);

    List<MenuNode> getMenusByRoleIds(List<String> roleIds);
}
