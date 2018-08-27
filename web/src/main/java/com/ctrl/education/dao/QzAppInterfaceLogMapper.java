package com.ctrl.education.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ctrl.education.model.QzAppInterfaceLog;

import java.util.Map;

/**
 * <p>
 * 接口访问日志 Mapper 接口
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
public interface QzAppInterfaceLogMapper extends BaseMapper<QzAppInterfaceLog> {

    Map<String, Object> getChart(Map<String, Object> param);

}
