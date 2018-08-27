package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzGiftOrders;
import com.ctrl.education.model.QzScoreGift;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 积分兑换礼品表 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
public interface IQzScoreGiftService extends IService<QzScoreGift> {

    Result getList(Map<String, Object> map);

    Result save(QzScoreGift qzScoreGift);

    Result modify(QzScoreGift qzScoreGift);

    Result remove(String id);

    Result getInfo(String id);
}
