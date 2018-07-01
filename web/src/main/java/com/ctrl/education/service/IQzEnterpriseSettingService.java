package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzEnterpriseSetting;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 企业信息配置表 服务类
 * </p>
 *
 * @since 2018-06-04
 */
public interface IQzEnterpriseSettingService extends IService<QzEnterpriseSetting> {

    Result getQZEntSettingById(Integer id);

    Result add(QzEnterpriseSetting qzEnterpriseSetting);
    Result modify(QzEnterpriseSetting qzEnterpriseSetting);

    Result getSettingInfo(String enterprise_id);
}
