package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
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
@RequestMapping("/sysDict")
public class SysDictController {

    @Autowired
    private ISysDictService sysDictService;

    /**
     * 根据字典类型id获取字典列表
     *
     * @param params
     * @return
     */
    @BussinessLog(value = "获取字典", type = "2")
    @RequestMapping("list")
    public Result list(@RequestParam Map<String, Object> params) {

        PageUtils page = sysDictService.queryPage(params);

        return page.toLayTableResult();
    }

    /**
     * 根据id获取字典
     *
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id获取字典", type = "2")
    @RequestMapping("info/{id}")
    public Result info(@PathVariable("id") Integer id) {

        SysDict sysDict = sysDictService.selectById(id);

        return Result.ok().put(SystemConstant.RESULT_KEY, sysDict);
    }

    @BussinessLog(value = "根据类型名称获取字典", type = "3")
    @RequestMapping("getDictsByTypeName/{typeName}")
    public Result getDictsByTypeName(@PathVariable("typeName") String typeName) {

        List<SysDictDto> dicts = sysDictService.getDictsByTypeName(typeName);

        return Result.ok().put(SystemConstant.RESULT_KEY, dicts);
    }

    /**
     * 判断字典值是否存在
     *
     * @param id
     * @param typeId
     * @param value
     * @return
     */
    @BussinessLog(value = "判断字典值是否存在", type = "3")
    @RequestMapping("hasValue/{id}/{typeId}/{value}")
    public Result hasValue(@PathVariable("id") Integer id, @PathVariable("typeId") Integer typeId,
                           @PathVariable("value") String value) {
        return Result.ok().put("hasValue", sysDictService.hasValue(id, typeId, value));
    }

    @BussinessLog(value = "增加字典", type = "3")
    @RequestMapping(value = "save")
    public Result save(SysDict sysDict) {

        ValidatorUtils.validateEntity(sysDict, AddGroup.class);

        Result result = sysDictService.save(sysDict);

        return result;
    }

    @BussinessLog(value = "修改字典", type = "3")
    @RequestMapping("modify")
    public Result modify(SysDict sysDict) {

        ValidatorUtils.validateEntity(sysDict, UpdateGroup.class);

        Result result = sysDictService.modify(sysDict);

        return result;
    }

    /**
     * 删除字典
     *
     * @param id
     * @return
     */
    @BussinessLog(value = "获取字典", type = "3")
    @RequestMapping("remove/{id}")
    public Result remove(@PathVariable("id") Integer id) {

        Result result = sysDictService.remove(id);

        return result;
    }

    /**
     * 获取考试分类下拉列表
     */
    @BussinessLog(value = "获取考试分类", type = "3")
    @RequestMapping("selectExam")
    public Result selectExam() {
        Result result = sysDictService.selectExamType();
        return result;
    }
}

