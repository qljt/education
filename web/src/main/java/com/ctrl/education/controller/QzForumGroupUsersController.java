package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.service.IQzForumGroupUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 论坛小组成员 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-17
 */
@RestController
@RequestMapping("/qzForumGroupUsers")
public class QzForumGroupUsersController {
    @Autowired
    private IQzForumGroupUsersService iQzForumGroupUsersService;

    /**
     * 小组成员列表
     */
    @BussinessLog(value = "根据id获取论坛小组成员",type = "2")
    @RequestMapping("getQzUsersByGroup")
    public Result getQzusersByGroup(@RequestParam Map<String,Object> param){
        Result result = iQzForumGroupUsersService.getQzusersByGroup(param);
        return result;
    }

}

