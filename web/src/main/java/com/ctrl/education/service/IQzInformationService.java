package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzInformation;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 动态资讯 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-06
 */
public interface IQzInformationService extends IService<QzInformation> {

    Result getList(Map<String,Object> param);

    Result save(QzInformation qzInformation);

    Result modify(QzInformation qzInformation);

    Result getInfo(String id);

    Result remove(String id);

    Result putInfo(QzInformation qzInformation);
}
