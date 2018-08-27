package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.service.ISysUserOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 单位人员关联表 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-03
 */
@RestController
@RequestMapping("/sysUserOffice")
public class SysUserOfficeController {
    @Autowired
    private ISysUserOfficeService iSysUserOfficeService;
    /**
     *根据用户id获取扩展信息
     * @param map
     * @return
     */
    @BussinessLog(value = "根据用户id获取扩展信息",type = "3")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String, Object> map){
        Result result =  this.iSysUserOfficeService.getList(map);
        return result;
    }
}

