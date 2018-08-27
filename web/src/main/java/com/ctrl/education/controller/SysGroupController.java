package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.model.SysGroup;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.model.SysUserGroup;
import com.ctrl.education.model.SysUserRole;
import com.ctrl.education.service.ISysGroupService;
import com.ctrl.education.service.ISysUserGroupService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户分组 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-07-31
 */
@RestController
@RequestMapping("/sysGroup")
public class SysGroupController {
    @Autowired
    private ISysGroupService iSysGroupService;
    @Autowired
    private ISysUserGroupService iSysUserGroupService;
    /**
     * 获取用户分组的tree列表
     */
    @BussinessLog(value = "获取用户分组的tree列表",type = "2")
    @RequestMapping(value = "/tree")
    public Result tree() {
        Result result = this.iSysGroupService.tree();
        return result;
    }
    /**
     * 获取分组列表
     */
    @BussinessLog(value = "获取分组列表",type = "2")
    @RequestMapping("list")
    public List<Map<String,Object>> getList(@RequestParam Map<String,Object> map){
        List<Map<String,Object> > result = iSysGroupService.getList(map);
        return result;
    }
    /**
     * 保存用户分组
     */
    @BussinessLog(value = "保存用户分组",type = "3")
    @RequestMapping(value = "add")
    public Result save(SysGroup sysGroup){
        ValidatorUtils.validateEntity(sysGroup,AddGroup.class);
        Result result = iSysGroupService.save(sysGroup);
        return result;
    }
    /**
     * 修改用户分组
     */
    @BussinessLog(value = "=修改用户分组",type = "3")
    @RequestMapping(value = "modify")
    public Result modify(SysGroup sysGroup){
        ValidatorUtils.validateEntity(sysGroup,UpdateGroup.class);
        Result result = this.iSysGroupService.modify(sysGroup);
        return result;
    }
    @BussinessLog(value = "根据id删除用户分组",type = "3")
    @RequestMapping(value = "remove")
    public Result remove(@RequestParam(value = "id") String id){
        Result result = iSysGroupService.remove(id);

        return result;
    }
    /**
     * 根据id获取用户分组
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id获取用户分组",type ="2")
    @RequestMapping("info")
    public Result getInfo(@RequestParam(value = "id")String id){
        Map<String,Object> sysGroup =  this.iSysGroupService.selectGroupById(id);
        return Result.ok().put(SystemConstant.RESULT_KEY,sysGroup);

    }
    /**
     * 根据用户获取岗位tree
     *
     * @param userId
     * @return
     */
    /*@RequestMapping("groupTreeListByUserId")
    public Result roleTreeListByUserId(@RequestParam("userId") String userId) {
        List<SysUserGroup> list = this.iSysUserGroupService.selectGroupByUseryId(userId);
        if (ToolUtils.isEmpty(list)) {
            List<ZTreeNode> roleTreeList = this.iSysGroupService.groupTreeList();
            return Result.ok().put(SystemConstant.RESULT_KEY, roleTreeList);
        } else {
            List<String> groupList=new ArrayList<>();
            for (SysUserGroup sysUserGroup:list) {
                groupList.add(sysUserGroup.getGroupId());
            }
            String[] strings = new String[groupList.size()];
            List<ZTreeNode> roleTreeListByUserId = this.iSysUserGroupService.groupTreeListByUserId(groupList.toArray(strings));
            return Result.ok().put(SystemConstant.RESULT_KEY, roleTreeListByUserId);
        }
    }*/
    /**
     * 根据用户获取岗位tree
     *
     * @param userId
     * @return
     */
    @RequestMapping("groupTreeListByUserId")
    public Result roleTreeListByUserId(@RequestParam("userId") String userId) {
        if (StringUtils.isEmpty(userId)) {
            List<ZTreeNode> roleTreeList = this.iSysGroupService.groupTreeList();
            return Result.ok().put(SystemConstant.RESULT_KEY, roleTreeList);
        } else {
            if (StringUtils.isEmpty(userId)) {
                return Result.error(SystemConstant.PARAM_NULL_ERROR);
            }
            List<ZTreeNode> roleTreeListByUserId = this.iSysGroupService.groupTreeListByUserId(userId);
            return Result.ok().put(SystemConstant.RESULT_KEY, roleTreeListByUserId);
        }
    }
}

