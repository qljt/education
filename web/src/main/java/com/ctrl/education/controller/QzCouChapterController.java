package com.ctrl.education.controller;

import com.ctrl.education.common.UploadFileUtil;
import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.file.ImageConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.model.QzCouChapter;
import com.ctrl.education.model.QzCourseware;
import com.ctrl.education.service.IQzCouChapterService;
import com.ctrl.education.service.IQzCoursewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/7/23.
 */
@RestController
@RequestMapping("/qzCouChapter")
public class QzCouChapterController extends BaseController {
    @Autowired
    private IQzCouChapterService iQzCouChapterService;

    @BussinessLog(value = "添加章", type = "3")
    @RequestMapping("add")
    public Result addChapter(QzCouChapter qzCouChapter){
        Result result = iQzCouChapterService.addChapter(qzCouChapter);
        return result;
    }
}
