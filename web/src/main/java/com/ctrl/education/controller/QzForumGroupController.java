package com.ctrl.education.controller;


import com.ctrl.education.common.UploadFileUtil;
import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.file.ImageConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzForumGroup;
import com.ctrl.education.service.IQzForumGroupService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 论坛小组 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-17
 */
@RestController
@RequestMapping("/qzForumGroup")
public class QzForumGroupController {
    @Autowired
    private IQzForumGroupService iQzForumGroupService;

    /**
     * 获取小组列表
     * @param param
     * @return
     */
    @BussinessLog(value = "获取论坛小组列表",type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String,Object> param){
        Result result = iQzForumGroupService.getList(param);
        return result;
    }

    /**
     * 添加小组
     * @param qzForumGroup
     * @return
     */
    @BussinessLog(value = "增加小组",type = "3")
    @RequestMapping("add")
    public Result add(QzForumGroup qzForumGroup){
        Result result = iQzForumGroupService.save(qzForumGroup);
        return result;
    }

    /**
     * 修改小组
     * @param qzForumGroup
     * @return
     */
    @BussinessLog(value = "修改小组",type = "3")
    @RequestMapping("modify")
    public Result modify(QzForumGroup qzForumGroup){
        Result result = iQzForumGroupService.modify(qzForumGroup);
        return result;
    }
    /**
     * 删除小组
     * @param qzForumGroup
     * @return
     */
    @BussinessLog(value = "删除小组",type = "3")
    @RequestMapping("remove")
    public Result remove(QzForumGroup qzForumGroup){
        Result result = iQzForumGroupService.remove(qzForumGroup);
        return result;
    }

    /**
     * 根据id获取小组
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id获取小组",type = "3")
    @RequestMapping("info")
    public Result getInfo(@RequestParam("id") String id){
        Result result = iQzForumGroupService.getInfo(id);
        return result;
    }
    /**
     * 禁用小组
     * @param qzForumGroup
     * @return
     */
    @BussinessLog(value = "禁用小组",type = "3")
    @RequestMapping("disable")
    public Result disable(QzForumGroup qzForumGroup){
        Result result = iQzForumGroupService.disable(qzForumGroup);
        return result;
    }


    /**
     * 上传封面
     * @param files
     * @param request
     * @return
     */
    @BussinessLog(value = "上传封面",type = "3")
    @RequestMapping("uploadCover")
    public Result uploadCover(MultipartFile[] files, HttpServletRequest request) {
        Result result = UploadFileUtil.uploadFile(files, ImageConstant.COVER_FILE_PATH,request);
        return result;
    }

    /**
     * 富文本编辑器上传图片
     * @param editorImages
     * @param request
     * @return
     */
    @RequestMapping("uploadEditImage")
    public Result uploadEditImage(MultipartFile[] editorImages, HttpServletRequest request) {

        Result result = UploadFileUtil.uploadFile(editorImages,ImageConstant.EDITOR_PATH,request);
        return result;
    }
}

