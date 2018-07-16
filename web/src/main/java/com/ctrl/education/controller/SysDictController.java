package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.model.SysDict;
import com.ctrl.education.model.SysMenu;
import com.ctrl.education.service.ISysDictService;
import com.ctrl.education.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统字典表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-07-15
 */
@RestController
@RequestMapping("/sysDict")
public class SysDictController {
    @Autowired
    private ISysDictService iSysDictService;

    /**
     * 获取字典树
     *
     * @return
     */
    @BussinessLog(value = "获取字典树", type = "2")
    @RequestMapping("tree")
    public Result getDicTree() {
        Result result = iSysDictService.getTreee();
        return result;
    }

    /**
     * 获取字典列表
     *
     * @param param
     * @return
     */
    @BussinessLog(value = "获取字典列表", type = "2")
    @RequestMapping("list")
    public List<Map<String, Object>> getList(@RequestParam Map<String, Object> param) {
        return iSysDictService.getList(param);

    }

    /**
     * 增加字典
     * @param sysDict
     * @return
     */
    @BussinessLog(value = "增加字典",type ="3")
    @RequestMapping("add")
    public Result save(SysDict sysDict) {
        ValidatorUtils.validateEntity(sysDict);
        Result result = this.iSysDictService.save(sysDict);
        return result;
    }
    /**
     * 修改字典
     * @param sysDict
     * @return
     */
    @BussinessLog(value = "修改字典",type ="3")
    @RequestMapping("modify")
    public Result modify(SysDict sysDict){
        ValidatorUtils.validateEntity(sysDict);
        Result result = this.iSysDictService.modify(sysDict);
        return result;
    }
    /**
     * 删除字典
     * @param id
     * @return
     */
    @BussinessLog(value = "删除字典",type ="3")
    @RequestMapping("remove")
    public Result remove(@RequestParam("id") String id){
        return this.iSysDictService.remove(id);

    }

    /**
     * 根据id获取字典
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id获取字典",type ="2")
    @RequestMapping("info")
    public Result getInfo(@RequestParam(value = "id")String id){
        SysDict sysDict =  this.iSysDictService.selectById(id);
        return Result.ok().put(SystemConstant.RESULT_KEY,sysDict);

    }



}

