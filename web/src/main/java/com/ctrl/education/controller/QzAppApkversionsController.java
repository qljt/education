package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.model.QzAppApkversions;
import com.ctrl.education.service.IQzAppApkversionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
@RestController
@RequestMapping("/qzAppApkversions")
public class QzAppApkversionsController {
    @Autowired
    private IQzAppApkversionsService iQzAppApkversionsService;

    /**
     * app版本控制列表
     * @param map
     * @return
     */
    @BussinessLog(value = "app版本控制列表",type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String,Object> map){
        Result result = iQzAppApkversionsService.getList(map);
        return result;
    }

    /**
     * 增加版本控制
     *  @param qzAppApkversions
     * @return
     */
    @BussinessLog(value = "add",type = "3")
    @RequestMapping("add")
    public Result save(QzAppApkversions qzAppApkversions){
        ValidatorUtils.validateEntity(qzAppApkversions,AddGroup.class);
        Result result = iQzAppApkversionsService.save(qzAppApkversions);
        return result;
    }

    /**
     * 修改版本控制
     * @param qzAppApkversions
     * @return
     */
    @BussinessLog(value = "modify",type = "3")
    @RequestMapping("modify")
    public Result modify(QzAppApkversions qzAppApkversions){
        ValidatorUtils.validateEntity(qzAppApkversions, UpdateGroup.class);
        Result result = iQzAppApkversionsService.modify(qzAppApkversions);
        return result;
    }
    /**
     * 根据id获取信息
     */
    @BussinessLog(value = "根据id获取版本控制信息",type = "2")
    @RequestMapping("info")
    public Result getInfo(@RequestParam("id") String id){
        Result result = iQzAppApkversionsService.getInfo(id);
        return result;
    }

    /**
     * 删除信息
     */
    @BussinessLog(value = "根据id获取版本控制信息",type = "3")
    @RequestMapping("remove")
    public Result remove(@RequestParam("id") String id){
        Result result = iQzAppApkversionsService.remove(id);
        return result;
    }
}

