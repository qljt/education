package com.ctrl.education.service;

import com.baomidou.mybatisplus.service.IService;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzEnterprise;

import java.util.Map;

/**
 * <p>
 * 企业表 服务类
 * </p>
 *
 * @author liyang
 * @since 2018-06-03
 */
public interface IQzEnterpriseService extends IService<QzEnterprise> {
    Result getList(Map<String,Object> params);

    Result add(QzEnterprise qzEnterprise);

    Result getEnterpriseById(String id);

    Result modify(QzEnterprise qzEnterprise);

    Result delete(String id);

    Result importExcel(String url);
}
