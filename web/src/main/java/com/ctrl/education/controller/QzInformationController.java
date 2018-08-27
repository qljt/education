package com.ctrl.education.controller;


import com.ctrl.education.common.UploadFileUtil;
import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.file.ImageConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzInformation;
import com.ctrl.education.service.IQzInformationService;
import org.apache.ibatis.executor.ResultExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;

/**
 * <p>
 * 动态资讯 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-06
 */
@RestController
@RequestMapping("/qzInformation")
public class QzInformationController {

    /**
     * 获取资讯列表
     */
    @Autowired
    private IQzInformationService iQzInformationService;
    @BussinessLog(value = "获取资讯列表",type = "3")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String,Object> param){
        Result result = iQzInformationService.getList(param);
        return result;
    }

    /**
     * 保存资讯
     * @param qzInformation
     * @return
     */
    @BussinessLog(value = "保存资讯",type = "2")
    @RequestMapping("add")
    public Result save(QzInformation qzInformation){
        Result result = iQzInformationService.save(qzInformation);
        return result;
    }

    /**
     * 修改资讯
     * @param qzInformation
     * @return
     */
    @BussinessLog(value = "修改资讯",type = "2")
    @RequestMapping("modify")
    public Result modify(QzInformation qzInformation){
        Result result = iQzInformationService.modify(qzInformation);
        return result;
    }

    /**
     * 发布资讯
     * @param qzInformation
     * @return
     */
    @BussinessLog(value = "发布资讯",type = "2")
    @RequestMapping("putInfo")
    public Result putInfo(QzInformation qzInformation){
        Result result = iQzInformationService.putInfo(qzInformation);
        return result;
    }

    /**
     *根据id查询资讯
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id查询资讯",type = "3")
    @RequestMapping("info/{id}")
    public Result getInfo(@PathVariable("id") String id){
        Result result = iQzInformationService.getInfo(id);
        return result;
    }

    /**
     *删除资讯
     * @param id
     * @return
     */
    @BussinessLog(value = "删除资讯",type = "3")
    @RequestMapping("remove/{id}")
    public Result remove(@PathVariable("id") String id){
        Result result = iQzInformationService.remove(id);
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
        Result result = UploadFileUtil.uploadFile(files,ImageConstant.COVER_FILE_PATH,request);
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

