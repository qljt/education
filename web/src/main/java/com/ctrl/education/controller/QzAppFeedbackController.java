package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.service.IQzAppFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 系统反馈 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
@RestController
@RequestMapping("/qzAppFeedback")
public class QzAppFeedbackController {
    @Autowired
    private IQzAppFeedbackService iQzAppFeedbackService;
    @BussinessLog(value = "获取系统反馈",type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String,Object> map){
        Result result = iQzAppFeedbackService.getList(map);
        return result;
    }


}

