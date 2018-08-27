package com.ctrl.education.controller;

import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzPaperFixed;
import com.ctrl.education.model.QzPaperQuestionType;
import com.ctrl.education.service.IQzPaperFixedService;
import com.ctrl.education.service.IQzPaperQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/23.
 */
@RestController
@RequestMapping("/qzPaperQuestionType")
public class QzPaperQuestionTypeController extends BaseController {
    @Autowired
    private IQzPaperQuestionTypeService iQzPaperQuestionTypeService;

    @BussinessLog(value = "添加问卷题型", type = "3")
    @RequestMapping("add")
    public Result add(QzPaperQuestionType qzPaperQuestionType) {
        Result result = iQzPaperQuestionTypeService.add(qzPaperQuestionType);
        return result;
    }
}
