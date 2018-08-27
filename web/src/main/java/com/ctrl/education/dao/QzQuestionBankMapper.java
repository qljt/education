package com.ctrl.education.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ctrl.education.model.QzQuestionBank;

/**
 * <p>
 * 题库表 Mapper 接口
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
public interface QzQuestionBankMapper extends BaseMapper<QzQuestionBank> {
    String selectMaxCode();
}
