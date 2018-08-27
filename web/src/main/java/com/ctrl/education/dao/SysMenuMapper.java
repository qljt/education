package com.ctrl.education.dao;

import com.ctrl.education.core.node.MenuNode;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.model.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    List<ZTreeNode> menuTreeListByMenuIds(@Param("roleId") String roleId);

    List<MenuNode> getMenusByRoleIds(List<String> roleIds);

    List<Map<String,Object>> selectChildById(@Param("id")String id);

    Map<String,Object> selectMenuById(String id);
}
