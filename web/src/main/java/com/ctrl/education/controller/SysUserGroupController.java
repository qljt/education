package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysUserGroup;
import com.ctrl.education.service.ISysUserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-07-31
 */
@RestController
@RequestMapping("/sysUserGroup")
public class SysUserGroupController {
    @Autowired
    private ISysUserGroupService iSysUserGroupService;
    /**
     * 分组用户列表
     *
     * @param map
     * @return
     */
    @BussinessLog(value = "分组用户列表", type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String, Object> map) {
        Result result = iSysUserGroupService.getList(map);
        return result;
    }

    /**
     * 分组用户列表
     *
     * @param groupId
     * @return
     */
    @BussinessLog(value = "分组用户列表", type = "2")
    @RequestMapping("getList/{groupId}")
    public List getList(@PathVariable("groupId") String groupId) {
       List list = iSysUserGroupService.getListByGroupId(groupId);
        return list;
    }

    /**
     *获取没在当前分组的其他的用户
     * @return
     */
    @BussinessLog(value = "获取没在当前分组的其他的用户", type = "2")
    @RequestMapping("getNotInGroupList/{groupId}")
    public List<Map<String,Object>> getNotInGroupList(@PathVariable("groupId") String groupId){
        List<Map<String,Object>> list= iSysUserGroupService.getNotInGroupList(groupId);
        return list;
    }

    /**
     * 添加用户到某个分组下
     * @param sysUserGroup
     * @return
     */
    @BussinessLog(value = "添加用户分组",type = "3")
    @RequestMapping("add")
    public Result add(@RequestBody SysUserGroup sysUserGroup){
       Result result =  iSysUserGroupService.add(sysUserGroup);
       return result;
    }
    /**
     * 删除分组用户
     * @param id
     * @return
     */
    @BussinessLog(value = "删除分组用户",type = "3")
    @RequestMapping("remove")
    public Result remove(@RequestParam("id")String id){
        Result result =  iSysUserGroupService.remove(id);
        return result;
    }

}

