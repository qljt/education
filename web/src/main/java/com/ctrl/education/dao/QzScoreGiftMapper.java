package com.ctrl.education.dao;

import com.ctrl.education.model.QzScoreGift;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 积分兑换礼品表 Mapper 接口
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
public interface QzScoreGiftMapper extends BaseMapper<QzScoreGift> {

    int remove(String id);
}
