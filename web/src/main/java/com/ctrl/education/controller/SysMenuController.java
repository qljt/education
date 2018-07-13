package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.model.SysMenu;
import com.ctrl.education.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @since 2018-06-23
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private ISysMenuService iSysMenuService;

    /**
     * 获取菜单列表
     *
     * @param map
     * @return
     */
    @BussinessLog(value = "获取菜单列表", type = "2")
    @RequestMapping("list")
    public List<Map<String,Object>> getList(@RequestParam Map<String, Object> map) {
        List<Map<String,Object>> list = iSysMenuService.getList(map);
        return list;
    }

    /**
     * 获取菜单列表(首页用)
     */
    @RequestMapping(value = "/menuTreeList")
    public Result menuTreeList() {
        List<ZTreeNode> menuTreeList = this.iSysMenuService.menuTreeList();
        return Result.ok().put(SystemConstant.RESULT_KEY, menuTreeList);
    }

    /**
     * 获取菜单列表(选择父级菜单用)
     */
    @BussinessLog(value = "获取菜单列表(选择父级菜单用)",type = "2")
    @RequestMapping(value = "/selectMenuTreeList")
    public Result selectMenuTreeList() {
        List<ZTreeNode> menuTreeList = this.iSysMenuService.menuTreeList();
        menuTreeList.add(ZTreeNode.createParent());
        return Result.ok().put(SystemConstant.RESULT_KEY, menuTreeList);
    }

    /**
     * 获取菜单列表
     */
    @RequestMapping(value = "/menuTreeListByRoleId/{roleId}")
    public List<ZTreeNode> menuTreeListByRoleId(@PathVariable String roleId) {
        List<String> menuIds = this.iSysMenuService.getMenuIdsByRoleId(roleId);
        if (ToolUtils.isEmpty(menuIds)) {
            List<ZTreeNode> roleTreeList = this.iSysMenuService.menuTreeList();
            return roleTreeList;
        } else {
            List<ZTreeNode> roleTreeListByUserId = this.iSysMenuService.menuTreeListByMenuIds(menuIds);
            return roleTreeListByUserId;
        }
    }

    /**
     * 增加菜单
     * @param sysMenu
     * @return
     */
    @BussinessLog(value = "增加菜单",type ="3")
    @RequestMapping("add")
    public Result save(SysMenu sysMenu) {
        ValidatorUtils.validateEntity(sysMenu);
        Result result = this.iSysMenuService.save(sysMenu);
        return result;
    }
    /**
     * 增加菜单
     * @param sysMenu
     * @return
     */
    @BussinessLog(value = "修改菜单",type ="3")
    @RequestMapping("modify")
    public Result modify(SysMenu sysMenu){
        ValidatorUtils.validateEntity(sysMenu);
        Result result = this.iSysMenuService.modify(sysMenu);
        return result;
    }

    /**
     * 根据id获取菜单
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id获取菜单",type ="2")
    @RequestMapping("info")
    public Result getInfo(@RequestParam(value = "id")String id){
       SysMenu sysMenu =  this.iSysMenuService.selectById(id);
       return Result.ok().put(SystemConstant.RESULT_KEY,sysMenu);

    }
}

