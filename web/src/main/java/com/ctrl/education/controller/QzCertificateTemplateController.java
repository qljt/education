package com.ctrl.education.controller;

import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.service.IQzCertificateTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/23.
 */
@RestController
@RequestMapping("/qzCertificateTemplate")
public class QzCertificateTemplateController extends BaseController {
    @Autowired
    private IQzCertificateTemplateService iQzCertificateTemplateService;

    @BussinessLog(value = "获取证书模板列表", type = "3")
    @RequestMapping("selectTemplate")
    public Result list() {
        Result result = iQzCertificateTemplateService.selectTemplate();
        return result;
    }

}
