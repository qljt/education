package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 系统日志 前端控制器
 * </p>
 *
 * @since 2018-06-03
 */
@RestController
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService iSysLogService;
    @BussinessLog(value = "日志列表",type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String,Object> map){
        Result result = iSysLogService.getList(map);
        return result;

    }
}

