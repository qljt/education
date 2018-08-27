package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzGiftOrders;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 兑换记录 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
public interface IQzGiftOrdersService extends IService<QzGiftOrders> {

    Result getList(Map<String, Object> map);

    Result agree(QzGiftOrders qzGiftOrders);

    Result refuse(QzGiftOrders qzGiftOrders);
}
