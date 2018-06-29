package com.ctrl.education.controller;


import com.ctrl.education.common.UploadFileUtil;
import com.ctrl.education.core.file.ImageConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.model.QzEnterpriseSetting;
import com.ctrl.education.service.IQzEnterpriseSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p>
 * 企业信息配置表 前端控制器
 * </p>
 *
 * @author liyang
 * @since 2018-06-04
 */
@RestController
@RequestMapping("/qzEnterpriseSetting")
public class QzEnterpriseSettingController {
    @Autowired
    private IQzEnterpriseSettingService iQzEnterpriseSettingService;

    /**
     * 根据id获取企业配置信息
     * @param id
     * @return
     */
    @GetMapping("info")
    public Result getQZEntSettingById(@RequestParam(value = "id") Integer id){
        Result result = iQzEnterpriseSettingService.getQZEntSettingById(id);
        return result;
    }

    /**
     * 保存企业配置信息
     * @param qzEnterpriseSetting
     * @return
     */
    @PostMapping("save")
    public Result save(QzEnterpriseSetting qzEnterpriseSetting){
        ValidatorUtils.validateEntity(qzEnterpriseSetting);
        Result result = iQzEnterpriseSettingService.save(qzEnterpriseSetting);
        return result;
    }

    /**
     * 根据企业id获取洗液设置信息
     * @param enterprise_id
     * @return
     */
    @GetMapping("getSettingInfo")
    public Result getSettingInfo(@PathVariable(value = "enterprise_id") String enterprise_id){
       Result result =  iQzEnterpriseSettingService.getSettingInfo(enterprise_id);
        return result;
    }

    //文件上传
    @PostMapping("uploadfile")
    public Result uploadfile(MultipartFile[] files, HttpServletRequest request) throws IOException {
        //文件夹路径
        String folderPath = ImageConstant.ENTERPRISE_SETTING_FILE_PATH;
        //接收文件并保存
       return  new UploadFileUtil().uploadFile(files, folderPath,request);
    }
}

