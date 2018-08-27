package com.ctrl.education.controller;


import com.ctrl.education.common.UploadFileUtil;
import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.file.ImageConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.dto.SysUserDto;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.service.ISysUserService;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @since 2018-06-23
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private ISysUserService iSysUserService;

    /**
     * 用户列表
     *
     * @param map
     * @return
     */
    @BussinessLog(value = "查询用户", type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String, Object> map) {
        Result result = iSysUserService.getList(map);
        return result;
    }

    /**
     * 添加用户
     *
     * @param sysUser
     * @return
     */
    @BussinessLog(value = "增加用户", type = "3")
    @PostMapping("add")
    public Result save(@RequestBody SysUser sysUser) {
        Result result = iSysUserService.save(sysUser);
        return result;
    }

    /**
     * 修改用户
     *
     * @param sysUser
     * @return
     */
    @BussinessLog(value = "修改用户", type = "3")
    @RequestMapping("modify")
    public Result modify(@RequestBody SysUser sysUser) {
        Result result = iSysUserService.modify(sysUser);
        return result;
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id删除用户", type = "3")
    @RequestMapping("remove")
    public Result remove(@RequestParam(value = "id") String id) {
        Result result = iSysUserService.remove(id);
        return result;
    }

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id查询用户", type = "2")
    @RequestMapping("info")
    public Result getSysUser(@RequestParam(value = "id") String id) {
        Result result = iSysUserService.getSysUser(id);
        return result;
    }

    /**
     * 修改密码
     *
     * @param map
     * @return
     */
    @BussinessLog(value = "修改密码", type = "3")
    @RequestMapping("resetPWD")
    public Result resetPWD(@RequestParam Map<String, Object> map) {
        Result result = iSysUserService.resetPWD(map);
        return result;
    }

    /**
     * 上传头像
     * @param files
     * @param request
     * @return
     */
    @BussinessLog(value = "上传头像",type = "3")
    @RequestMapping("uploadAvatar")
    public Result uploadAvatar(MultipartFile[] files, HttpServletRequest request) {
        Result result = UploadFileUtil.uploadFile(files,ImageConstant.AVATAR_FILE_PATH,request);
        return result;
    }

    /**
     * 修改用户状态
     * @param map
     * @return
     */
    @BussinessLog(value = "修改用户状态",type = "3")
    @RequestMapping("updateSysUserStatus")
    public Result updateSysUserStatus(@RequestParam Map<String, Object> map){
        Result result = this.iSysUserService.updateSysUserStatus(map);
        return result;
    }

}
