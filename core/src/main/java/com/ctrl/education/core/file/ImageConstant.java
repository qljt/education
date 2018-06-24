package com.ctrl.education.core.file;

import java.io.File;

/**
 * com.ctrl.education.core.file
 *
 * @author liyang
 * @name ImageConstant
 * @description
 * @date 2018-06-10 下午9:11
 */
public class ImageConstant {
    // 上传文件根路径
    public static final String ROOT_PATH = "/www/wwwroot/default";


    // 图片路径
    public static final String EDITOR_PATH = File.separator + "images" + File.separator + "editor"; // 富文本编译器图片路径
    public static final String ENTERPRISE_FILE_PATH = File.separator + "excel" + File.separator + "enterprise"; //企业模块附件
    // 异常编码及提示
    public static final String UPLOAD_IMG_SUCCESS_MSG = "图片上传成功";
    public static final String NULL_EXCEPTION_CODE = "I0001";
    public static final String NULL_EXCEPTION_MSG = "上传图片不可为空";
}
