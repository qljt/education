package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.service.ISysLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 登录日志 前端控制器
 * </p>
 *
 * @since 2018-06-23
 */
@RestController
@RequestMapping("/sysLoginLog")
public class SysLoginLogController {
    @Autowired
    private ISysLoginLogService iSysLoginLogService;

    /**
     * 获取登录日志
     * @param param
     * @return
     */
    @BussinessLog(value = "查询登录日志",type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String,Object> param){
        Result result = iSysLoginLogService.getList(param);
        return result;
    }

}

