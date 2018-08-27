package com.ctrl.education.controller;

import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzPaper;
import com.ctrl.education.model.QzPaperPart;
import com.ctrl.education.service.IQzPaperPartService;
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
@RequestMapping("/qzPaperPart")
public class QzPaperPartController extends BaseController {
    @Autowired
    private IQzPaperPartService iQzPaperPartService;

    @BussinessLog(value = "添加试卷区块", type = "3")
    @RequestMapping("add")
    public Result list(QzPaperPart qzPaperPart) {
        Result result = iQzPaperPartService.add(qzPaperPart);
        return result;
    }

}
