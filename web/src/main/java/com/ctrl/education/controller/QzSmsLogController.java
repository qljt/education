package com.ctrl.education.controller;


import com.ctrl.education.core.utils.Result;
import com.ctrl.education.service.IQzSmsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 短信记录表 前端控制器
 * </p>
 *
 * @since 2018-06-20
 */
@RestController
@RequestMapping("/qzSmsLog")
public class QzSmsLogController {
    @Autowired
    private IQzSmsLogService iQzSmsLogService;

    /**
     * 短信记录
     * @param map
     * @return
     */
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String, Object> map){
        Result result = iQzSmsLogService.getList(map);
        return result;

    }
}

