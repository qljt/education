package com.ctrl.education.controller;


import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.model.SysDictType;
import com.ctrl.education.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 * 系统字典表 前端控制器
 * </p>
 *
 * @author liyang
 * @since 2018-06-03
 */
@RestController
@RequestMapping("/sysDictType")
public class SysDictTypeController {
    @Autowired
    private ISysDictTypeService sysDictTypeService;

    @GetMapping("list")
    public Result list(@RequestParam Map<String, Object> params) {

        PageUtils page = sysDictTypeService.queryPage(params);

        return page.toLayTableResult();
    }

    @GetMapping("info/{id}")
    public Result info(@PathVariable("id") Integer id){

        SysDictType sysDictType = sysDictTypeService.selectById(id);

        return Result.ok().put(SystemConstant.RESULT_KEY, sysDictType);
    }

    @GetMapping("hasName/{id}/{name}")
    public Result hasName(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        return Result.ok().put("hasName", sysDictTypeService.hasName(id, name));
    }

    @PostMapping(value = "save")
    public Result save(@RequestBody SysDictType sysDictType) {

        ValidatorUtils.validateEntity(sysDictType, AddGroup.class);

        sysDictTypeService.insert(sysDictType);

        return Result.ok();
    }

    @PutMapping("update")
    public Result update(@RequestBody SysDictType sysDictType) {

        ValidatorUtils.validateEntity(sysDictType, UpdateGroup.class);

        sysDictTypeService.updateById(sysDictType);

        return Result.ok();
    }

    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable("id") Integer id) {

        sysDictTypeService.deleteById(id);

        return Result.ok();
    }
}

