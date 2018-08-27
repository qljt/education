package com.ctrl.education.controller;

import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzTestQuestionAnswer;
import com.ctrl.education.service.IQzTestQuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/23.
 */
@RestController
@RequestMapping("/qzTestQuestionAnswer")
public class QzTestQuestionAnswerController extends BaseController {
    @Autowired
    private IQzTestQuestionAnswerService iQzTestQuestionAnswerService;

    @BussinessLog(value = "添加客观题答案", type = "3")
    @RequestMapping("add")
    public Result add(QzTestQuestionAnswer qzTestQuestionAnswer) {
        Result result = iQzTestQuestionAnswerService.add(qzTestQuestionAnswer);
        return result;
    }
}
