package com.ctrl.education.controller;


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
    @GetMapping("list")
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
    @PostMapping("add")
    public Result add(@RequestBody QzEnterprise qzEnterprise){
        ValidatorUtils.validateEntity(qzEnterprise,AddGroup.class);
        Result result= iQzEnterpriseService.add(qzEnterprise);
        return result;
    }
    /**
     *编辑企业信息
     * @param qzEnterprise
     * @return
     */
    @BussinessLog(value = "编辑企业信息",type = "3")
    @PostMapping("modify")
    public Result modify(@RequestBody QzEnterprise qzEnterprise){
        ValidatorUtils.validateEntity(qzEnterprise,AddGroup.class);
        Result result= iQzEnterpriseService.modify(qzEnterprise);
        return result;
    }
    /**
     * 根据id获取企业信息
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id获取企业信息",type ="2")
    @GetMapping("info")
    public Result getEnterpriseById(@PathVariable(value = "id") String id){
        Result result = iQzEnterpriseService.getEnterpriseById(id);
        return result;
    }

    /**
     * 根据多个id删除企业信息
     * @param ids
     * @return
     */
    @GetMapping("remove")
    public Result delete(@RequestParam(value = "ids[]") String[] ids){
        Result result = iQzEnterpriseService.delete(ids);
        return result;
    }

    /**
     * 上传文件到服务器
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @GetMapping("importExcel")
    public Result importQzEnterprise(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException{
        String folderPath = ImageConstant.ENTERPRISE_FILE_PATH;
        Result result = ExcelUtils.uploadExcel(file,folderPath,request);
      return result;

    }

    @PostMapping(value = "importExcel")
    public Result importExcel(HttpServletRequest request, @RequestBody String url) throws IOException {
        Result result = iQzEnterpriseService.importExcel(url);
        return result;
    }
}

