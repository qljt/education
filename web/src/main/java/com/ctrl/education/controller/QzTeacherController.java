package com.ctrl.education.controller;


import com.ctrl.education.common.UploadFileUtil;
import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.file.ImageConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzTeacher;
import com.ctrl.education.service.IQzSmsLogService;
import com.ctrl.education.service.IQzTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 * 教师表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-07-20
 */
@RestController
@RequestMapping("/qzTeacher")
public class QzTeacherController {

    @Autowired
    private IQzTeacherService iQzTeacherService;

    /**
     * 获取教师列表
     *
     * @param params
     * @return
     */
    @BussinessLog(value = "获取教师列表", type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String, Object> params) {
        Result result = this.iQzTeacherService.getList(params);
        return result;
    }

    /**
     * 添加教师
     *
     * @param qzTeacher
     * @return
     */
    @BussinessLog(value = "增加教师", type = "3")
    @RequestMapping("add")
    public Result save(QzTeacher qzTeacher) {
        Result result = this.iQzTeacherService.add(qzTeacher);
        return result;
    }

    /**
     * 修改教师
     *
     * @param qzTeacher
     * @return
     */
    @BussinessLog(value = "修改教师", type = "3")
    @RequestMapping("modify")
    public Result modify(QzTeacher qzTeacher) {
        Result result = this.iQzTeacherService.modify(qzTeacher);
        return result;
    }

    /**
     * 删除教师
     *
     * @param id
     * @return
     */
    @BussinessLog(value = "删除教师", type = "3")
    @RequestMapping("remove")
    public Result remove(@RequestParam(value = "id") String id) {
        Result result = this.iQzTeacherService.remove(id);
        return result;
    }

    /**
     * 根据id获取教师信息
     *
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id获取教师信息", type = "3")
    @RequestMapping("info")
    public Result getInfo(@RequestParam(value = "id")String id) {
        Result result = this.iQzTeacherService.getInfo(id);
        return result;
    }

    @BussinessLog(value = "教师头像上传", type = "3")
    @RequestMapping("uploadAvatar")
    public Result uploadAvatar(MultipartFile[] files, HttpServletRequest request) {
        Result result = UploadFileUtil.uploadFile(files, ImageConstant.AVATAR_FILE_PATH,request);
        return result;
    }

    @BussinessLog(value = "获取教师列表", type = "2")
    @RequestMapping("teacherList")
    public Result teacherList(@RequestParam Map<String,Object> map){
        Result result = this.iQzTeacherService.teacherList(map);
        return result;
    }

    @BussinessLog(value = "获取教师等级下拉列表", type = "2")
    @RequestMapping("selectTeacher")
    public Result selectTeacher(){
        Result result = this.iQzTeacherService.selectTeacher();
        return result;
    }

    /**
     * 获取评卷人员下拉列表
     * @return
     */
    @BussinessLog(value = "获取评卷人员下拉列表", type = "2")
    @RequestMapping("selectReview")
    public Result selectReview(){
        Result result = this.iQzTeacherService.selectReview();
        return result;
    }

    //文件上传
    @RequestMapping("uploadfile")
    public Result uploadfile(MultipartFile[] files, HttpServletRequest request) throws IOException {
        //文件夹路径
        String folderPath = ImageConstant.TEACHER_FILE_PATH;
        //接收文件并保存
        return  new UploadFileUtil().uploadFile(files, folderPath,request);
    }
}