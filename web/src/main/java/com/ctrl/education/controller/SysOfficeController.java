package com.ctrl.education.controller;


import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysOffice;
import com.ctrl.education.service.ISysOfficeService;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 机构表 前端控制器
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
@RestController
@RequestMapping("/sysOffice")
public class SysOfficeController {
    @Autowired
    private ISysOfficeService iSysOfficeService;
    @PostMapping
    public Result save(SysOffice sysOffice){
        return null;
    }

}

