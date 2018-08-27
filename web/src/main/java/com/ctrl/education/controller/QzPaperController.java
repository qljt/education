package com.ctrl.education.controller;

import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzPaper;
import com.ctrl.education.service.IQzPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/23.
 */
@RestController
@RequestMapping("/qzPaper")
public class QzPaperController extends BaseController {
    @Autowired
    private IQzPaperService iQzPaperService;

    @BussinessLog(value = "获取调查问卷列表", type = "3")
    @RequestMapping("list")
    public Result list(@RequestParam Map<String, Object> map) {
        Result result = iQzPaperService.list(map);
        return result;
    }

    @BussinessLog(value = "添加调查问卷", type = "3")
    @RequestMapping("add")
    public Result addQuestionnaire(QzPaper qzPaper) {
        Result result = iQzPaperService.add(qzPaper);
        return result;
    }

    @BussinessLog(value = "删除调查问卷", type = "3")
    @RequestMapping("delete")
    public Result deleteById(@RequestParam(value = "id") String id) {
        Result result = iQzPaperService.deleteById(id);
        return result;
    }

    @BussinessLog(value = "获取所有试卷", type = "3")
    @RequestMapping("selectPaper")
    public Result selectPaper(){
        Result result = iQzPaperService.selectPaper();
        return result;
    }
}
