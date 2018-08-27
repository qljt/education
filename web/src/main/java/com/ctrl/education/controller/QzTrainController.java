package com.ctrl.education.controller;


import com.ctrl.education.common.UploadFileUtil;
import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.file.ImageConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.service.IQzTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 * 培训任务列表 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@RestController
@RequestMapping("/qzTrain")
public class QzTrainController {
    @Autowired
    private IQzTrainService iQzTrainService;

    @BussinessLog(value = "获取培训任务列表", type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String,Object> map) {
        Result result = iQzTrainService.list(map);
        return result;
    }

    //文件上传
    @RequestMapping("uploadfile")
    public Result uploadfile(MultipartFile[] files, HttpServletRequest request) throws IOException {
        //文件夹路径
        String folderPath = ImageConstant.TRAIN_FILE_PATH;
        //接收文件并保存
        return  new UploadFileUtil().uploadFile(files, folderPath,request);
    }
}

