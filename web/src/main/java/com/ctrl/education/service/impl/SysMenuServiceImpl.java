package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.node.MenuNode;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.model.SysMenu;
import com.ctrl.education.dao.SysMenuMapper;
import com.ctrl.education.service.ISysMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    @Override
    public List<Map<String,Object>> getList(Map<String, Object> map) {
        String name = (String) map.get("name");
        List<Map<String,Object> >list = this.selectMaps( new EntityWrapper<SysMenu>()
                .like(StringUtils.isNotBlank(name), "name", name)
                .orderBy("num", true));

        return list;
    }

    @Override
    public  List<ZTreeNode> menuTreeList() {
        List<ZTreeNode> menuTreeList = this.baseMapper.menuTreeList();
        return menuTreeList;
    }

    @Override
    public List<String> getMenuIdsByRoleId(String roleId) {
        return this.baseMapper.getMenuIdsByRoleId(roleId);
    }

    @Override
    public List<ZTreeNode> menuTreeListByMenuIds(String roleId) {
        return this.baseMapper.menuTreeListByMenuIds(roleId);
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result save(SysMenu sysMenu) {
        if(hasCode(sysMenu)){
            return Result.error("菜单编号重复，不能添加");
        }
        menuSetPcode(sysMenu);
        boolean flag = this.insert(sysMenu);
        if(flag){
            return Result.ok(SystemConstant.ADD_SUCCESS);
        }else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result modify(SysMenu sysMenu) {
        menuSetPcode(sysMenu);
        boolean flag = this.updateById(sysMenu);
        if(flag){
            return Result.ok(SystemConstant.UPDATE_SUCCESS);
        }else {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }

    @Override

    public Result remove(String id) {
        if(StringUtils.isEmpty(id)){
            return Result.ok(SystemConstant.PARAM_ERROR);
        }
        boolean flag = this.deleteById(id);

        if(flag){
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        }else {
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }

    /**
     * 根据编码判断是否重复
     * @param sysMenu
     * @return
     */
    private boolean hasCode(SysMenu sysMenu){
        Map<String,Object> map  = new HashMap<>();
        map.put("code",sysMenu.getCode());
       List<SysMenu> list = this.baseMapper.selectByMap(map);
       if (ToolUtils.isNotEmpty(list)){
           return true;
       }
       return false;
    }
    /**
     * 根据请求的父级菜单编号设置pid和层级
     */
    private void menuSetPcode(SysMenu sysMenu) {
        if (ToolUtils.isEmpty(sysMenu.getPid()) || sysMenu.getPid().equals("0")) {
            sysMenu.setPid("0");
            sysMenu.setPids("0,");
            sysMenu.setLevels(1);
        } else {
           SysMenu menu =  this.selectById(sysMenu.getPid());
           Integer levels = menu.getLevels();
           sysMenu.setLevels(levels+1);
           sysMenu.setPid(menu.getId());
           sysMenu.setPids(menu.getPids()+""+menu.getId()+",");
        }
    }

    @Override
    public List<MenuNode> getMenusByRoleIds(List<String> roleIds) {
        return this.baseMapper.getMenusByRoleIds(roleIds);
    }
}
