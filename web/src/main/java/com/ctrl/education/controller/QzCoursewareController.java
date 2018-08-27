package com.ctrl.education.controller;

import com.ctrl.education.common.UploadFileUtil;
import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.file.ImageConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.model.QzCourseware;
import com.ctrl.education.model.QzTeacher;
import com.ctrl.education.service.IQzCoursewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/23.
 */
@RestController
@RequestMapping("/qzCourseware")
public class QzCoursewareController extends BaseController {
    @Autowired
    private IQzCoursewareService iQzCoursewareService;

    @BussinessLog(value = "获取课程列表", type = "3")
    @RequestMapping("list")
    public Result list(@RequestParam Map<String, Object> map) {
        Result result = iQzCoursewareService.list(map);
        return result;
    }

    @BussinessLog(value = "添加课程信息", type = "3")
    @RequestMapping("add")
    public Result addCourseware(QzCourseware qzCourseware) {
        ValidatorUtils.validateEntity(qzCourseware, AddGroup.class);
        Result result = iQzCoursewareService.addCourseware(qzCourseware);
        return result;
    }

    @BussinessLog(value = "查询讲师信息", type = "3")
    @RequestMapping("allTeacher")
    public Result allTeacher() {
        Result result = iQzCoursewareService.allTeacher();
        return result;
    }

    @BussinessLog(value = "查询课程分类信息", type = "3")
    @RequestMapping("selectClassify")
    public Result selectClassify() {
        Result result = iQzCoursewareService.selectClassify();
        return result;
    }

    @BussinessLog(value = "查询部门信息", type = "3")
    @RequestMapping("selectDept")
    public Result selectDept() {
        Result result = iQzCoursewareService.selectDept();
        return result;
    }

    @BussinessLog(value = "查询人员信息", type = "3")
    @RequestMapping("selectUser")
    public Result selectUser(String departIds) {
        Result result = iQzCoursewareService.selectUser(departIds);
        return result;
    }

    @BussinessLog(value = "删除课程", type = "3")
    @RequestMapping("remove")
    public Result remove(@RequestParam(value = "id") String id) {
        Result result = iQzCoursewareService.remove(id);
        return result;
    }

    @BussinessLog(value = "根据ID获取课程", type = "3")
    @RequestMapping("getCourwareById")
    public Result getCourwareById(@RequestParam(value = "id") String id) {
        Result result = iQzCoursewareService.getCourwareById(id);
        return result;
    }

    @BussinessLog(value = "修改课程", type = "3")
    @RequestMapping("modify")
    public Result modify(QzCourseware qzCourseware) {
        Result result = iQzCoursewareService.modify(qzCourseware);
        return result;
    }

    //文件上传
    @RequestMapping("uploadfile")
    public Result uploadfile(MultipartFile[] files, HttpServletRequest request) throws IOException {
        //文件夹路径
        String folderPath = ImageConstant.COVER_FILE_PATH;
        //接收文件并保存
        return new UploadFileUtil().uploadFile(files, folderPath, request);
    }
}
