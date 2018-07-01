package com.ctrl.education.controller;


import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.dto.SysDictDto;
import com.ctrl.education.model.SysDict;
import com.ctrl.education.service.ISysDictService;
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
 * @author liyang
 * @since 2018-06-03
 */
@RestController
@RequestMapping("/sysDict")
public class SysDictController {
    @Autowired
    private ISysDictService sysDictService;

    @GetMapping("list")
    public Result list(@RequestParam Map<String, Object> params) {

        PageUtils page = sysDictService.queryPage(params);

        return page.toLayTableResult();
    }

    @GetMapping("info/{id}")
    public Result info(@PathVariable("id") Integer id) {

        SysDict sysDict = sysDictService.selectById(id);

        return Result.ok().put(SystemConstant.RESULT_KEY, sysDict);
    }

    @GetMapping("getDictsByTypeName/{typeName}")
    public Result getDictsByTypeName(@PathVariable("typeName") String typeName) {

        List<SysDictDto> dicts = sysDictService.getDictsByTypeName(typeName);

        return Result.ok().put(SystemConstant.RESULT_KEY, dicts);
    }

    @GetMapping("hasValue/{id}/{typeId}/{value}")
    public Result hasValue(@PathVariable("id") Integer id, @PathVariable("typeId") Integer typeId,
                           @PathVariable("value") String value) {
        return Result.ok().put("hasValue", sysDictService.hasValue(id, typeId, value));
    }

    @PostMapping(value = "save")
    public Result save(@RequestBody SysDict sysDict) {

        ValidatorUtils.validateEntity(sysDict, AddGroup.class);

        sysDictService.insert(sysDict);

        return Result.ok();
    }

    @PutMapping("update")
    public Result update(@RequestBody SysDict sysDict) {

        ValidatorUtils.validateEntity(sysDict, UpdateGroup.class);

        sysDictService.updateById(sysDict);

        return Result.ok();
    }

    @DeleteMapping("remove/{id}")
    public Result delete(@PathVariable("id") Integer id) {

        sysDictService.deleteById(id);

        return Result.ok();
    }
}

