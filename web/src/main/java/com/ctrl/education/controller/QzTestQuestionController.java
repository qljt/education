package com.ctrl.education.controller;

import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzQuestionBank;
import com.ctrl.education.model.QzTestQuestions;
import com.ctrl.education.service.IQzQuestionBankService;
import com.ctrl.education.service.IQzTestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/23.
 */
@RestController
@RequestMapping("/qzTestQuestion")
public class QzTestQuestionController extends BaseController {
    @Autowired
    private IQzTestQuestionService iQzTestQuestionService;

    @BussinessLog(value = "添加试题", type = "3")
    @RequestMapping("add")
    public Result add(QzTestQuestions qzTestQuestions) {
        Result result = iQzTestQuestionService.add(qzTestQuestions);
        return result;
    }
}
