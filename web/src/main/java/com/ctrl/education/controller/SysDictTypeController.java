package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.model.SysDict;
import com.ctrl.education.model.SysDictType;
import com.ctrl.education.service.ISysDictService;
import com.ctrl.education.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统字典表 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-07-21
 */
@RestController
@RequestMapping("/sysDictType")
public class SysDictTypeController {
    @Autowired
    private ISysDictTypeService sysDictTypeService;

    /**
     * 获取字典类型
     * @param params 查询参数
     *
     * @return
     */
    @BussinessLog(value = "获取字典类型",type = "2")
    @RequestMapping("list")
    public Result list(@RequestParam Map<String, Object> params) {

        PageUtils page = sysDictTypeService.queryPage(params);

        return page.toLayTableResult();
    }

    /**
     * 根据id获取字典类型
     * @param id 主键
     * @return
     */
    @BussinessLog(value = "根据id获取字典类型",type = "2")
    @RequestMapping("info/{id}")
    public Result info(@PathVariable("id") Integer id){

        SysDictType sysDictType = sysDictTypeService.selectById(id);

        return Result.ok().put(SystemConstant.RESULT_KEY, sysDictType);
    }

    /**
     * 判断类型名称是否唯一
     * @param id
     * @param name
     * @return
     */
    @BussinessLog(value = "判断类型名称是否唯一",type = "2")
    @RequestMapping("hasName/{id}/{name}")
    public Result hasName(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        return Result.ok().put("hasName", sysDictTypeService.hasName(id, name));
    }

    /**
     * 保存字典类型
     * @param sysDictType
     * @return
     */
    @BussinessLog(value = "保存字典类型",type = "3")
    @RequestMapping(value = "save")
    public Result save(SysDictType sysDictType) {

        ValidatorUtils.validateEntity(sysDictType, AddGroup.class);

        Result result = sysDictTypeService.save(sysDictType);

        return result;
    }

    /**
     * 修改字典类型
     * @param sysDictType
     * @return
     */
    @RequestMapping("modify")
    @BussinessLog(value = "修改字典类型",type = "3")
    public Result modify(SysDictType sysDictType) {

        ValidatorUtils.validateEntity(sysDictType, UpdateGroup.class);

        Result result = sysDictTypeService.modify(sysDictType);

        return result;
    }

    /**
     * 删除字典类型
     * @param id
     * @return
     */
    @BussinessLog(value = "删除字典类型",type = "3")
    @RequestMapping("remove/{id}")
    public Result remove(@PathVariable("id") Integer id) {

        Result result = sysDictTypeService.remove(id);

        return result;
    }
}

