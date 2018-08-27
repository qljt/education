package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzUsers;
import com.ctrl.education.service.IQzUsersScoreRecordService;
import com.ctrl.education.service.IQzUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 用户积分记录 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@RestController
@RequestMapping("/qzUsers")
public class QzUsersController {
    @Autowired
    private IQzUsersService iQzUsersService;

    @BussinessLog(value = "获取用户下拉列表", type = "2")
    @RequestMapping("selectUsers")
    public Result getList(@RequestParam(value = "departId") String departId) {
        Result result = iQzUsersService.selectUser(departId);
        return result;
    }

    @BussinessLog(value = "根据ID获取用户", type = "3")
    @RequestMapping("getUserById")
    public Result getUserById(@RequestParam(value = "id") String id) {
        Result result = iQzUsersService.getUserById(id);
        return result;
    }
}

