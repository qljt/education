package com.ctrl.education.common;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.file.FileUtil;
import com.ctrl.education.core.utils.file.UploadUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

import java.util.ArrayList;
import java.util.List;

/**
 * com.ctrl.education.common
 *
 * @name UploadFileUtil
 * @description
 * @date 2018-06-27 14:36
 */
public class UploadFileUtil {
    public static Result uploadFile(MultipartFile[] files, String folderPath, HttpServletRequest request) {
        try {
            String filePath;
            //接收文件并保存
            Result result = new UploadUtil().uploadFileToLocal(files, folderPath, request);
            //将json格式转换成数组格式
            JSONArray url = JSONUtil.parseArray(result.get("url"));
            List<String> path = new ArrayList<>();
            for (int i = 0; i < url.size(); i++) {
                //文件路径
                String newurl = ((JSONObject) url.get(0)).get("url").toString().replace("\\", "/");
                result.put("url", newurl);
                filePath = newurl;
                path.add(filePath);
            }
            return result.put("msg",SystemConstant.UPLOAD_IMG_SUCCESS_MSG).put("code", 10000).put("result", path);
        } catch (Exception exception) {
            exception.printStackTrace();
            return Result.error(SystemConstant.UPLOAD_IMG_ERROR_MSG);
        }
    }

    /**
     * @param images     需上传的图片
     * @param folderPath 图片存放的路径
     * @return
     */
    public static Result uploadImages(MultipartFile[] images, String imagePath, String folderPath) {
        try {
            List<String> imgUrl = new ArrayList<String>();
            for (MultipartFile imageFile : images) {
                // 当前系统改时间戳
                long currentTimeMillis = System.currentTimeMillis();
                // 文件名
                String fileName = imageFile.getOriginalFilename();
                // 保存文件路径
                String filePath = imagePath + File.separator + folderPath + File.separator + currentTimeMillis
                        + File.separator + fileName;
                // 文件相对路径
                String oppositePath = folderPath + File.separator + currentTimeMillis
                        + File.separator + fileName;
                // 创建文件夹
                FileUtil.createDir(filePath);
                // 保存
                imageFile.transferTo(new File(filePath));
                // 存储至集合
                imgUrl.add(oppositePath);
            }
            return Result.ok(SystemConstant.UPLOAD_IMG_SUCCESS_MSG).put("imageUrl", imgUrl);
        } catch (Exception exception) {
            exception.printStackTrace();
            return Result.error(SystemConstant.UPLOAD_IMG_ERROR_MSG);
        }
    }
}
