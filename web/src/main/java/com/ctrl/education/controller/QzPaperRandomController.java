package com.ctrl.education.controller;

import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzPaperRandom;
import com.ctrl.education.service.IQzPaperRandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/23.
 */
@RestController
@RequestMapping("/qzPaperRandom")
public class QzPaperRandomController extends BaseController {
    @Autowired
    private IQzPaperRandomService iQzPaperRandomService;

    @BussinessLog(value = "添加随机卷抽题规则", type = "3")
    @RequestMapping("add")
    public Result add(QzPaperRandom qzPaperRandom) {
        Result result = iQzPaperRandomService.add(qzPaperRandom);
        return result;
    }
}
