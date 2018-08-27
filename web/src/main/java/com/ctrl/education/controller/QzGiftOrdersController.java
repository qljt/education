package com.ctrl.education.controller;


import com.ctrl.education.core.annotation.BussinessLog;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzGiftOrders;
import com.ctrl.education.service.IQzGiftOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 兑换记录 前端控制器
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@RestController
@RequestMapping("/qzGiftOrders")
public class QzGiftOrdersController {
    @Autowired
    private IQzGiftOrdersService iQzGiftOrdersService;

    /**
     * 获取兑换记录列表
     * @param map
     * @return
     */
    @BussinessLog(value = "获取积分兑换记录",type = "2")
    @RequestMapping("list")
    public Result getList(@RequestParam Map<String,Object> map){
        Result result = iQzGiftOrdersService.getList(map);
        return result;

    }

    /**
     * 同意兑换
     * @return
     */
    @BussinessLog(value = "同意兑换",type = "3")
    @RequestMapping("agree")
    public Result agree(QzGiftOrders qzGiftOrders){
        Result result = iQzGiftOrdersService.agree(qzGiftOrders);
        return result;
    }
    /**
     * 拒绝兑换
     * @return
     */
    @BussinessLog(value = "拒绝兑换",type = "3")
    @RequestMapping("refuse")
    public Result refuse(QzGiftOrders qzGiftOrders){
        Result result = iQzGiftOrdersService.refuse(qzGiftOrders);
        return result;
    }
}

