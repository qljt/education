package com.ctrl.education.controller;

import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzCouChapter;
import com.ctrl.education.model.QzCouChapterSection;
import com.ctrl.education.service.IQzCouChapterSectionService;
import com.ctrl.education.service.IQzCouChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/23.
 */
@RestController
@RequestMapping("/qzCouChapterSection")
public class QzCouChapterSectionController extends BaseController {
    @Autowired
    private IQzCouChapterSectionService iQzCouChapterSectionService;

    @BussinessLog(value = "添加小节", type = "3")
    @RequestMapping("add")
    public Result addChapterSection(QzCouChapterSection qzCouChapterSection){
        Result result = iQzCouChapterSectionService.addChapterSection(qzCouChapterSection);
        return result;
    }
}
