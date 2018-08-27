package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.service.IQzAppInterfaceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 接口访问日志 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
@RestController
@RequestMapping("/qzAppInterfaceLog")
public class QzAppInterfaceLogController {

    @Autowired
    private IQzAppInterfaceLogService iQzAppInterfaceLogService;

    /**
     * 接口访问日志列表
     * @param map
     * @return
     */
    @BussinessLog(value = "接口访问日志",type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String,Object> map){
        Result result = iQzAppInterfaceLogService.getList(map);
        return result;
    }
}

