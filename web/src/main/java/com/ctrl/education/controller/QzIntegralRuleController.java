package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzIntegralRule;
import com.ctrl.education.service.IQzIntegralRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 积分规则表 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@RestController
@RequestMapping("/qzIntegralRule")
public class QzIntegralRuleController {

    @Autowired
    private IQzIntegralRuleService iQzIntegralRuleService;
    @BussinessLog(value = "修改积分规则",type = "3")
    @RequestMapping("modify")
    public Result modify(QzIntegralRule qzIntegralRule){
       Result result = iQzIntegralRuleService.modify(qzIntegralRule);
       return result;
    }

    @BussinessLog(value = "获取积分规则列表",type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String,Object> map){
        Result result = iQzIntegralRuleService.getList(map);
        return result;
    }
}

