package com.ctrl.education.controller;


import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.model.QzEnterpriseSetting;
import com.ctrl.education.service.IQzEnterpriseSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 企业信息配置表 前端控制器
 * </p>
 *
 * @author liyang
 * @since 2018-06-04
 */
@RestController
@RequestMapping("/qzEnterpriseSetting")
public class QzEnterpriseSettingController {
    @Autowired
    private IQzEnterpriseSettingService iQzEnterpriseSettingService;

    /**
     * 根据id获取企业配置信息
     * @param id
     * @return
     */
    @GetMapping("info")
    public Result getQZEntSettingById(@RequestParam(value = "id") Integer id){
        Result result = iQzEnterpriseSettingService.getQZEntSettingById(id);
        return result;
    }

    /**
     * 保存企业配置新
     * @param qzEnterpriseSetting
     * @return
     */
    @PostMapping("save")
    public Result save(QzEnterpriseSetting qzEnterpriseSetting){
        ValidatorUtils.validateEntity(qzEnterpriseSetting);
        Result result = iQzEnterpriseSettingService.save(qzEnterpriseSetting);
        return result;
    }
}

