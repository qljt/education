package com.ctrl.education.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.model.SysConfig;
import com.ctrl.education.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统配置表 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
@RestController
@RequestMapping("/sysConfig")
public class SysConfigController {

    @Autowired
    private ISysConfigService iSysConfigService;

    /**
     * 获取系统配置信息
     * @return
     */
    @BussinessLog(value = "获取系统配置信息",type = "2")
    @RequestMapping("info")
    public SysConfig getInfo(){
        SysConfig sysConfig =  iSysConfigService.selectOne(new EntityWrapper<SysConfig>());
        return sysConfig;
    }
    /**
     * 修改系统配置
     */
    @BussinessLog(value = "修改系统配配置",type = "3")
    @RequestMapping("modify")
    public Result modify(SysConfig sysConfig){
        ValidatorUtils.validateEntity(sysConfig, UpdateGroup.class);
       boolean flag = iSysConfigService.updateById(sysConfig);
       if(flag){
           return Result.ok(SystemConstant.UPDATE_SUCCESS);
       }else {
           return Result.error(SystemConstant.UPDATE_FAILURE);
       }
    }

}

