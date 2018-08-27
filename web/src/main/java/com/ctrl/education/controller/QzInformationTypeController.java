package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.model.QzInformationType;
import com.ctrl.education.service.IQzInformationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资讯分类 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-06
 */
@RestController
@RequestMapping("/qzInformationType")
public class QzInformationTypeController {

    @Autowired
    private IQzInformationTypeService iQzInformationTypeService;

    /**
     * 获取新闻分类的tree列表
     */
    @BussinessLog(value = "获取新闻分类的tree列表",type = "2")
    @RequestMapping(value = "/tree/{param}")
    public Result tree(@PathVariable("param") String param) {
        Result result = this.iQzInformationTypeService.tree(param);
        return result;
    }
    /**
     * 获取新闻分类列表
     */
    @BussinessLog(value = "获取分组列表",type = "2")
    @RequestMapping("list")
    public List<Map<String,Object>> getList(@RequestParam Map<String,Object> map){
        List<Map<String,Object> > result = iQzInformationTypeService.getList(map);
        return result;
    }
    /**
     * 获取新闻分类列表
     */
    @BussinessLog(value = "获取分组列表",type = "2")
    @RequestMapping("getInformationTypeList")
    public Result getList(){
        List<QzInformationType> list = iQzInformationTypeService.getInformationTypeList();
        return Result.ok().put(SystemConstant.RESULT_KEY,list);
    }

    /**
     * 保存新闻分类
     */
    @BussinessLog(value = "保存新闻分类",type = "3")
    @RequestMapping(value = "add")
    public Result save(QzInformationType qzInformationType){
        ValidatorUtils.validateEntity(qzInformationType, AddGroup.class);
        Result result = iQzInformationTypeService.save(qzInformationType);
        return result;
    }
    /**
     * 修改新闻分类
     */
    @BussinessLog(value = "=修改新闻分类",type = "3")
    @RequestMapping(value = "modify")
    public Result modify(QzInformationType qzInformationType){
        ValidatorUtils.validateEntity(qzInformationType, UpdateGroup.class);
        Result result = this.iQzInformationTypeService.modify(qzInformationType);
        return result;
    }
    @BussinessLog(value = "根据id删除新闻分类",type = "3")
    @RequestMapping(value = "remove")
    public Result remove(@RequestParam(value = "id") String id){
        Result result = iQzInformationTypeService.remove(id);

        return result;
    }
    /**
     * 根据id获取新闻分类
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id获取新闻分类",type ="2")
    @RequestMapping("info")
    public Result getInfo(@RequestParam(value = "id")String id){
        Map<String,Object> QzInformationType =  this.iQzInformationTypeService.selectQzInformationTypeById(id);
        return Result.ok().put(SystemConstant.RESULT_KEY,QzInformationType);

    }
}

