package com.ctrl.education.controller;

import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzPaper;
import com.ctrl.education.model.QzPaperFixed;
import com.ctrl.education.service.IQzPaperFixedService;
import com.ctrl.education.service.IQzPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/23.
 */
@RestController
@RequestMapping("/qzPaperFixed")
public class QzPaperFixedController extends BaseController {
    @Autowired
    private IQzPaperFixedService iQzPaperFixedService;

    @BussinessLog(value = "添加固定卷试卷题目", type = "3")
    @RequestMapping("add")
    public Result add(QzPaperFixed qzPaperFixed) {
        Result result = iQzPaperFixedService.add(qzPaperFixed);
        return result;
    }
}
