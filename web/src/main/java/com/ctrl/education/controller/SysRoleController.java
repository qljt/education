package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.model.SysOffice;
import com.ctrl.education.model.SysRole;
import com.ctrl.education.service.ISysRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @since 2018-06-23
 */
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {
    @Autowired
    private ISysRoleService iSysRoleService;

    /**
     * 获取角色列表
     * @param map
     * @return
     */
    @BussinessLog(value = "获取角色列表",type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String,Object> map){
        Result result = iSysRoleService.getList(map);
        return result;
    }

    /**
     * 获取角色的tree列表
     */
    @BussinessLog(value = "获取角色的tree列表",type = "2")
    @RequestMapping(value = "/roleTreeList")
    public Result roleTreeList() {
        Result result = iSysRoleService.tree();
        return result;
    }

    /**
     * 根据用户获取角色tree
     * @param userId
     * @return
     */
    @RequestMapping("roleTreeListByUserId")
    public Result roleTreeListByUserId(@RequestParam(value = "userId") String userId){
        Result result = iSysRoleService.roleTreeListByUserId(userId);
        return result;

    }

    /**
     * 根据角色id查询角色对象
     * @param id
     * @return
     */
    @BussinessLog(value = "根据角色ida查询角色",type = "2")
    @RequestMapping("info/{id}")
    public Result getRoleById(@PathVariable("id") String id){
        SysRole sysRole = iSysRoleService.selectById(id);
        return Result.ok().put(SystemConstant.RESULT_KEY,sysRole);
    }
    /**
     * 增加角色
     * @param sysRole
     * @return
     */
    @BussinessLog(value = "添加角色",type = "3")
    @RequestMapping("add")
    public Result add(SysRole sysRole){
        ValidatorUtils.validateEntity(sysRole);
        roleSetPids(sysRole);
        Result result = iSysRoleService.add(sysRole);
        return result;
    }
    /**
     * 修改角色
     * @param sysRole
     * @return
     */
    @BussinessLog(value = "修改角色",type = "3")
    @RequestMapping("modify")
    public Result modify(SysRole sysRole){
        ValidatorUtils.validateEntity(sysRole);
        roleSetPids(sysRole);
        Result result = iSysRoleService.modify(sysRole);
        return result;
    }

    /**
     * 根据id删除角色
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id删除角色",type = "3")
    @RequestMapping("remove")
    public Result remove(@RequestParam(value = "id") String id){
        Result result = iSysRoleService.remove(id);

        return result;
    }
    @BussinessLog(value = "设置角色的权限",type = "3")
    @RequestMapping("setAuthority")
    public Result setAuthority(@RequestParam("roleId") String roleId, @RequestParam("ids") String ids){

        Result result =iSysRoleService.setAuthority(roleId,ids);
        return result;
    }
    private void roleSetPids(SysRole sysRole) {
        if (StringUtils.isEmpty(sysRole.getPid()) || sysRole.getPid().equals(0)) {
            sysRole.setPid("0");
            sysRole.setPids("0,");
        } else {
            String pid = sysRole.getPid();
            SysRole temp = iSysRoleService.selectById(pid);
            String pids = temp.getPids();
            sysRole.setPid(pid);
            sysRole.setPids(pids + "" + pid + ",");
        }
    }
}

