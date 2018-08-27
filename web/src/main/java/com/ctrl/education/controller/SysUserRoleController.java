package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-07-31
 */
@RestController
@RequestMapping("/sysUserRole")
public class SysUserRoleController {
    @Autowired
    private ISysUserRoleService iSysUserRoleService;
    /**
     * 分配角色
     *
     * @param id
     * @param roleIds
     * @return
     */
    @BussinessLog(value = "分配角色", type = "3")
    @RequestMapping("setRole")
    public Result setRole(@RequestParam("id") String id, @RequestParam("roleIds") String roleIds) {

        Result result = iSysUserRoleService.setRole(id, roleIds);
        return result;
    }
}

