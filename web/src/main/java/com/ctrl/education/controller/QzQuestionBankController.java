package com.ctrl.education.controller;

import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzQuestionBank;
import com.ctrl.education.service.IQzQuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/23.
 */
@RestController
@RequestMapping("/qzQuestionBank")
public class QzQuestionBankController extends BaseController {
    @Autowired
    private IQzQuestionBankService iQzQuestionBankService;

    @BussinessLog(value = "添加问卷题库", type = "3")
    @RequestMapping("add")
    public Result add(QzQuestionBank qzQuestionBank) {
        Result result = iQzQuestionBankService.add(qzQuestionBank);
        return result;
    }
}
