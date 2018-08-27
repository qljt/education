package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.service.IQzMajorService;
import com.ctrl.education.service.IQzTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 专业表 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@RestController
@RequestMapping("/qzMajor")
public class QzMajorController {
    @Autowired
    private IQzMajorService iQzMajorService;

    @BussinessLog(value = "获取培训任务下拉列表", type = "2")
    @RequestMapping("selectMajor")
    public Result selectMajor() {
        Result result = iQzMajorService.selectMajor();
        return result;
    }

    @BussinessLog(value = "根据ID获取类型", type = "3")
    @RequestMapping("getMajorById")
    public Result getMajorById(@RequestParam(value = "id") String id) {
        Result result = iQzMajorService.getMajorById(id);
        return result;
    }
}

