package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.model.SysOffice;
import com.ctrl.education.service.ISysOfficeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @BussinessLog(value = "获取组织机构的tree列表", type = "2")
    @RequestMapping(value = "/officeTree")
    public Result tree() {
        Result result = this.iSysOfficeService.officeTree();
        return result;
    }

    /**
     * 获取组织机构的下拉框选择
     */
    @BussinessLog(value = "获取组织机构的下拉框选择列表", type = "2")
    @RequestMapping(value = "/officeSelect")
    public Result officeSelect() {
        Result result = this.iSysOfficeService.officeSelect();
        return result;
    }

    /**
     * 获取组织机构的tree列表
     */
    @BussinessLog(value = "获取组织机构的tree列表", type = "2")
    @RequestMapping(value = "/deptList")
    public Result tree1() {
        Result result = this.iSysOfficeService.deptTree();
        return result;
    }

    /**
     * 获取机构列表
     */
    @BussinessLog(value = "获取机构列表", type = "2")
    @RequestMapping("list")
    public List<Map<String, Object>> getList(@RequestParam Map<String, Object> map) {
        List<Map<String, Object>> result = iSysOfficeService.getList(map);
        return result;
    }

    /**
     * 保存组织机构
     */
    @BussinessLog(value = "保存组织机构", type = "3")
    @RequestMapping(value = "add")
    public Result save(SysOffice sysOffice) {
        ValidatorUtils.validateEntity(sysOffice, AddGroup.class);
//        officeSetPids(sysOffice);
        Result result = this.iSysOfficeService.save(sysOffice);
        return result;
    }

    /**
     * 修改组织机构
     */
    @BussinessLog(value = "=修改组织机构", type = "3")
    @RequestMapping(value = "modify")
    public Result modify(SysOffice sysOffice) {
        ValidatorUtils.validateEntity(sysOffice, UpdateGroup.class);
        officeSetPids(sysOffice);
        Result result = this.iSysOfficeService.modify(sysOffice);
        return result;
    }

    @BussinessLog(value = "根据id删除组织机构", type = "3")
    @RequestMapping(value = "remove")
    public Result remove(@RequestParam(value = "id") String id) {
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

    /**
     * 根据id获取组织机构
     *
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id获取组织机构", type = "2")
    @RequestMapping("info")
    public Result getInfo(@RequestParam(value = "id") String id) {
        Map<String, Object> sysOffice = this.iSysOfficeService.selectOfficeById(id);
        return Result.ok().put(SystemConstant.RESULT_KEY, sysOffice);

    }

    @BussinessLog(value = "根据code获取部门", type = "3")
    @RequestMapping("getDeptByCode")
    public Result getDeptByCode(@RequestParam(value = "code") String code) {
        Result result = this.iSysOfficeService.getDeptByCode(code);
        return result;
    }

    /**
     * 获取部门的下拉列表后期可以修改为部门，单位，可选的接口
     */
    @BussinessLog(value = "获取部门或单位", type = "2")
    @RequestMapping("selectOffice")
    public Result selectDept(Integer type) {
        Result result = this.iSysOfficeService.selectOfficeByType(type);
        return result;
    }
}

