package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.model.SysOffice;
import com.ctrl.education.service.ISysOfficeService;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 机构表 前端控制器
 * </p>
 *
 * @since 2018-06-23
 */
@RestController
@RequestMapping("/sysOffice")
public class SysOfficeController {
    @Autowired
    private ISysOfficeService iSysOfficeService;
    /**
     * 获取组织机构的tree列表
     */
    @BussinessLog(value = "获取组织机构的tree列表",type = "2")
    @RequestMapping(value = "/tree")
    public Result tree() {
        Result result = this.iSysOfficeService.tree();
        return result;
    }
    /**
     * 保存组织机构
     */
    @BussinessLog(value = "保存组织机构",type = "3")
    @RequestMapping(value = "add")
    public Result save(SysOffice sysOffice){
        ValidatorUtils.validateEntity(sysOffice,AddGroup.class);
        officeSetPids(sysOffice);
        Result result = this.iSysOfficeService.save(sysOffice);
        return result;
    }
    /**
     * 修改组织机构
     */
    @BussinessLog(value = "=修改组织机构",type = "3")
    @RequestMapping(value = "modify")
    public Result modify(SysOffice sysOffice){
        ValidatorUtils.validateEntity(sysOffice,UpdateGroup.class);
        officeSetPids(sysOffice);
        Result result = this.iSysOfficeService.modify(sysOffice);
        return result;
    }
    @BussinessLog(value = "根据id删除组织机构",type = "3")
    @RequestMapping(value = "remove")
    public Result remove(@RequestParam(value = "id") String id){
        Result result = iSysOfficeService.remove(id);

        return result;
    }
    private void officeSetPids(SysOffice sysOffice) {
        if (StringUtils.isEmpty(sysOffice.getPid()) || sysOffice.getPid().equals(0)) {
            sysOffice.setPid("0");
            sysOffice.setPids("0,");
        } else {
            String pid = sysOffice.getPid();
            SysOffice temp = iSysOfficeService.selectById(pid);
            String pids = temp.getPids();
            sysOffice.setPid(pid);
            sysOffice.setPids(pids + "" + pid + ",");
        }
    }
}

