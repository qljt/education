package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzInformationType;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资讯分类 服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-06
 */
public interface IQzInformationTypeService extends IService<QzInformationType> {

    Result tree(String param);

    List<Map<String, Object>> getList(Map<String, Object> map);

    Result save(QzInformationType qzInformationType);

    Result modify(QzInformationType qzInformationType);

    Result remove(String id);

    Map<String, Object> selectQzInformationTypeById(String id);

    List<QzInformationType> getInformationTypeList();
}
