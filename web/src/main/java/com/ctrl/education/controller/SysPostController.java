package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.model.SysPost;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.model.SysUserPost;
import com.ctrl.education.model.SysUserRole;
import com.ctrl.education.service.ISysPostService;
import com.ctrl.education.service.ISysUserPostService;
import com.ctrl.education.service.ISysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 岗位表 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-07-23
 */
@RestController
@RequestMapping("/sysPost")
public class SysPostController {
    @Autowired
    private ISysPostService iSysPostService;
    /**
     * 获取岗位的tree列表
     */
    @BussinessLog(value = "获取岗位的tree列表", type = "2")
    @RequestMapping(value = "/tree")
    public Result tree() {
        Result result = this.iSysPostService.tree();
        return result;
    }

    /**
     * 获取岗位的下拉框列表
     */
    @BussinessLog(value = "获取岗位的下拉框列表", type = "2")
    @RequestMapping(value = "/postSelect")
    public Result postSelect() {
        Result result = this.iSysPostService.postSelect();
        return result;
    }

    /**
     * 获取岗位列表
     */
    @BussinessLog(value = "获取岗位列表", type = "2")
    @RequestMapping("list")
    public List<Map<String, Object>> getList(@RequestParam Map<String, Object> map) {
        List<Map<String, Object>> result = iSysPostService.getList(map);
        return result;
    }

    /**
     * 保存岗位
     */
    @BussinessLog(value = "保存岗位", type = "3")
    @RequestMapping(value = "add")
    public Result save(SysPost sysPost) {
        ValidatorUtils.validateEntity(sysPost, AddGroup.class);
        Result result = this.iSysPostService.save(sysPost);
        return result;
    }

    /**
     * 修改岗位
     */
    @BussinessLog(value = "=修改岗位", type = "3")
    @RequestMapping(value = "modify")
    public Result modify(SysPost sysPost) {
        ValidatorUtils.validateEntity(sysPost, UpdateGroup.class);
        Result result = this.iSysPostService.modify(sysPost);
        return result;
    }

    @BussinessLog(value = "根据id删除岗位", type = "3")
    @RequestMapping(value = "remove")
    public Result remove(@RequestParam(value = "id") String id) {
        Result result = iSysPostService.remove(id);

        return result;
    }

    /**
     * 根据id获取岗位
     *
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id获取岗位", type = "2")
    @RequestMapping("info")
    public Result getInfo(@RequestParam(value = "id") String id) {
        Map<String, Object> sysPost = this.iSysPostService.selectPostById(id);
        return Result.ok().put(SystemConstant.RESULT_KEY, sysPost);

    }

    /**
     * 根据用户获取岗位tree
     *
     * @param userId
     * @return
     */
   /* @RequestMapping("postTreeListByUserId")
    public Result roleTreeListByUserId(@RequestParam("userId") String userId) {
        if (StringUtils.isEmpty(userId)) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        List<SysUserPost> list = iSysUserPostService.selectByMap(map);
        if (StringUtils.isEmpty(userId)) {
            List<ZTreeNode> roleTreeList = this.iSysPostService.postTreeList();
            return Result.ok().put(SystemConstant.RESULT_KEY, roleTreeList);
        } else {
            List<String> postList=new ArrayList<>();
            for (SysUserPost sysUserPost:list) {
                postList.add(sysUserPost.getPostId());
            }
            String[] strings = new String[postList.size()];
            List<ZTreeNode> roleTreeListByUserId = this.iSysPostService.postTreeListByUserId(postList.toArray(strings));
            return Result.ok().put(SystemConstant.RESULT_KEY, roleTreeListByUserId);
        }
    }*/
    /**
     * 根据用户获取岗位tree
     *
     * @param userId
     * @return
     */
    @RequestMapping("postTreeListByUserId")
    public Result roleTreeListByUserId(@RequestParam("userId") String userId) {
        if (StringUtils.isEmpty(userId)) {
            List<ZTreeNode> roleTreeList = this.iSysPostService.postTreeList();
            return Result.ok().put(SystemConstant.RESULT_KEY, roleTreeList);
        } else {
            if (StringUtils.isEmpty(userId)) {
                return Result.error(SystemConstant.PARAM_NULL_ERROR);
            }
            List<ZTreeNode> roleTreeListByUserId = this.iSysPostService.postTreeListByUserId(userId);
            return Result.ok().put(SystemConstant.RESULT_KEY, roleTreeListByUserId);
        }
    }
}

