package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzIntegralRule;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 积分规则表 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
public interface IQzIntegralRuleService extends IService<QzIntegralRule> {

    Result modify(QzIntegralRule qzIntegralRule);

    Result getList(Map<String,Object> map);
}
