package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.model.SysOffice;
import com.ctrl.education.model.SysRole;
import com.ctrl.education.service.ISysRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
     * 获取角色的tree列表
     */
    @BussinessLog(value = "获取角色的tree列表",type = "2")
    @RequestMapping(value = "/tree")
    public Result tree() {
        Result result = this.iSysRoleService.tree();
        return result;
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
    @BussinessLog(value = "根据id删除角色",type = "3")
    @RequestMapping("remove")
    public Result remove(@RequestParam(value = "id") String id){
        Result result = iSysRoleService.remove(id);

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

