package com.ctrl.education.core.utils.file;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.ctrl.education.core.file.ImageConstant;
import com.ctrl.education.core.utils.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * com.ctrl.education.core.utils
 *
 * @name UploadUtil
 * @description
 * @date 2018-06-27 14:30
 */
public class UploadUtil {
    /**
     *  接收文件并保存
     * @param files
     * @param folderPath
     * @return
     */
    public Result uploadFileToLocal(MultipartFile[] files, String folderPath, HttpServletRequest request) throws IOException, IllegalStateException{
        Result r = new Result();
        JSONArray url =null;
        if(files.length<1){
            return Result.ok("").put("errmsg","上传的文件不允许为空");
        }else{
            url = new JSONArray();
            for(MultipartFile file:files){
                synchronized (this) {
                    FileUtil.createDir(folderPath);
                    String fileName = file.getOriginalFilename();
                    String suffix = fileName.substring(fileName.lastIndexOf("."));
                    String reName = String.valueOf(System.currentTimeMillis());
                    File targetFile = new File(ImageConstant.ROOT_PATH +folderPath, reName + suffix);
                    if (!targetFile.exists()) {
                        targetFile.mkdirs();
                    }
                    //保存
                    try {
                        file.transferTo(targetFile);
                        JSONObject fileObj = new JSONObject();
                        //保存后的地址（存数据库的地址）
                        fileObj.put("url",folderPath + File.separator + reName + suffix);
                        //拼时间锉后的名字
                        fileObj.put("name",reName + suffix);
                        //原文件名
                        fileObj.put("title",file.getOriginalFilename());
                        url.add(fileObj);
                        return r.ok().put("url",url);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return r.ok().put("url",url);
    }

    /**
     *  接收excel文件并保存
     * @param file
     * @param folderPath
     * @return
     */
    public String uploadFileToLocal(MultipartFile file, String folderPath) throws IllegalStateException{
        String filePath = "";
        synchronized (this) {
            FileUtil.createDir(folderPath);
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            String reName = String.valueOf(System.currentTimeMillis());
            File targetFile = new File(folderPath, reName + suffix);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            //保存
            try {
                file.transferTo(targetFile);
                filePath = folderPath + File.separator + reName + suffix;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return filePath;
    }
}
