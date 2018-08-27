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
   // public static final String ROOT_PATH = "/www/wwwroot/
    //133服务器路径
    public static final String ROOT_PATH = "F:\\svnSpaces\\admin-web\\education-admin\\dist";
//    public static final String ROOT_PATH = "/Users/liyang/project/qljt/web/education-admin/dist";



    // 图片路径
    public static final String EDITOR_PATH = File.separator + "image" + File.separator + "editor"; // 富文本编译器图片路径
    public static final String ENTERPRISE_FILE_PATH = File.separator + "excel" + File.separator + "enterprise"; //企业模块附件
    public static final String ENTERPRISE_SETTING_FILE_PATH = File.separator + "excel" + File.separator + "enterpriseSetting"; //企业设置模块附件
    public static final String COVER_FILE_PATH = File.separator + "image" + File.separator + "cover";//封面图路径
    public static final String AVATAR_FILE_PATH = File.separator + "image" + File.separator + "avatar";//头像
    public static final String TEACHER_FILE_PATH = File.separator + "image1" + File.separator + "icon";//教师照片
    public static final String TRAIN_FILE_PATH = File.separator + "train" + File.separator + "icon";//培训照片
    // 异常编码及提示
    public static final String UPLOAD_IMG_SUCCESS_MSG = "图片上传成功";
    public static final String NULL_EXCEPTION_CODE = "I0001";
    public static final String NULL_EXCEPTION_MSG = "上传图片不可为空";
}
