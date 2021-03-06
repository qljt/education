package com.ctrl.education.controller;


import com.ctrl.education.common.UploadFileUtil;
import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.constant.SysConstant;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.controller.BaseController;
import com.ctrl.education.core.file.ImageConstant;
import com.ctrl.education.core.utils.ExcelUtils;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.model.QzEnterprise;
import com.ctrl.education.service.IQzEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 * 企业表 前端控制器
 * </p>
 *
 * @author liyang
 * @since 2018-06-03
 */
@RestController
@RequestMapping("/qzEnterprise")
public class QzEnterpriseController extends BaseController {
    @Autowired
    private IQzEnterpriseService iQzEnterpriseService;

    /**
     * 分页获取企业信息
     * @param params 查询信息
     * @return result
     */
    @BussinessLog(value = "分页获取企业信息",type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String,Object> params){
        Result result = iQzEnterpriseService.getList(params);
        return result;
    }

    /**
     *保存企业信息
     * @param qzEnterprise
     * @return
     */
    @BussinessLog(value = "添加企业信息",type = "3")
    @RequestMapping("add")
    public Result add(QzEnterprise qzEnterprise){

        Result result= iQzEnterpriseService.add(qzEnterprise);
        return result;
    }
    /**
     *编辑企业信息
     * @param qzEnterprise
     * @return
     */
    @BussinessLog(value = "编辑企业信息",type = "3")
    @RequestMapping("modify")
    public Result modify( QzEnterprise qzEnterprise){

        Result result= iQzEnterpriseService.modify(qzEnterprise);
        return result;
    }
    /**
     * 根据id获取企业信息
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id获取企业信息",type ="2")
    @RequestMapping("info/{id}")
    public Result getEnterpriseById(@PathVariable("id") String id){
        Result result = iQzEnterpriseService.getEnterpriseById(id);
        return result;
    }

    /**
     * 根据id删除企业信息
     * @param qzEnterprise
     * @return
     */
    @RequestMapping("remove")
    public Result remove(QzEnterprise qzEnterprise){
        Result result = iQzEnterpriseService.delete(qzEnterprise);
        return result;
    }
    /**
     * 启用禁用企业
     * @param qzEnterprise
     * @return
     */
    @RequestMapping("disable")
    public Result disable(QzEnterprise qzEnterprise){
        Result result = iQzEnterpriseService.disable(qzEnterprise);
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

