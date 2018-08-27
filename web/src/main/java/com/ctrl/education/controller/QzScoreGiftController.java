package com.ctrl.education.controller;


import com.ctrl.education.common.UploadFileUtil;
import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.file.ImageConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzGiftOrders;
import com.ctrl.education.model.QzScoreGift;
import com.ctrl.education.service.IQzScoreGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 积分兑换礼品表 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@RestController
@RequestMapping("/qzScoreGift")
public class QzScoreGiftController {
    @Autowired
    private IQzScoreGiftService iQzScoreGiftService;

    /**
     * 获取礼品列表
     * @param map
     * @return
     */
    @BussinessLog(value = "获取礼品列表",type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String,Object> map){
        Result result = iQzScoreGiftService.getList(map);
        return result;
    }

    /**
     * 增加礼品
     * @param qzScoreGift
     * @return
     */
    @BussinessLog(value = "新增礼品",type = "3")
    @RequestMapping("add")
    public Result save(QzScoreGift qzScoreGift){
        Result result = iQzScoreGiftService.save(qzScoreGift);
        return result;
    }
    /**
     * 修改礼品
     * @param qzScoreGift
     * @return
     */
    @BussinessLog(value = "修改礼品",type = "3")
    @RequestMapping("modify")
    public Result modify(QzScoreGift qzScoreGift){
        Result result = iQzScoreGiftService.modify(qzScoreGift);
        return result;
    }
    /**
     * 删除礼品
     * @param id
     * @return
     */
    @BussinessLog(value = "删除礼品",type = "3")
    @RequestMapping("remove")
    public Result remove(@RequestParam("id") String id){
        Result result = iQzScoreGiftService.remove(id);
        return result;
    }
    /**
     * 根据id获取礼品
     * @param id
     * @return
     */
    @BussinessLog(value = "根据id获取礼品",type = "3")
    @RequestMapping("info")
    public Result getInfo(@RequestParam("id") String id){
        Result result = iQzScoreGiftService.getInfo(id);
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
        Result result = UploadFileUtil.uploadFile(files, ImageConstant.COVER_FILE_PATH,request);
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

