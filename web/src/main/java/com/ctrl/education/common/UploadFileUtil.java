package com.ctrl.education.common;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.file.UploadUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
    public Result uploadFile(MultipartFile[] files, String folderPath, HttpServletRequest request) throws IOException {
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
        return result.put("msg", "").put("code", 10000).put("result", path);
    }

}
