package com.ctrl.education.controller;

import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzCouChapter;
import com.ctrl.education.model.QzExamination;
import com.ctrl.education.service.IQzCouChapterService;
import com.ctrl.education.service.IQzExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2018/7/23.
 */
@RestController
@RequestMapping("/qzExamination")
public class QzExaminationController extends BaseController {
    @Autowired
    private IQzExaminationService iQzExaminationService;

    @BussinessLog(value = "添加问卷管理试题", type = "3")
    @RequestMapping("add")
    public Result add(QzExamination qzExamination) {
        Result result = iQzExaminationService.add(qzExamination);
        return result;
    }

    @BussinessLog(value = "获取考试安排列表", type = "3")
    @RequestMapping("list")
    public Result list(@RequestParam Map<String, Object> map) {
        Result result = iQzExaminationService.list(map);
        return result;
    }

    @BussinessLog(value = "添加考试安排", type = "3")
    @RequestMapping("addExamination")
    public Result addExamination(QzExamination qzExamination) {
        Result result = this.iQzExaminationService.addExamination(qzExamination);
        return result;
    }

    @BussinessLog(value = "删除考试安排", type = "3")
    @RequestMapping("remove")
    public Result remove(@RequestParam("id") String id) {
        Result result = iQzExaminationService.remove(id);
        return result;
    }
}
