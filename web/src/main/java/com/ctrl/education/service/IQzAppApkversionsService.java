package com.ctrl.education.service;

import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzAppApkversions;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
public interface IQzAppApkversionsService extends IService<QzAppApkversions> {

    Result getList(Map<String, Object> map);

    Result save(QzAppApkversions qzAppApkversions);

    Result modify(QzAppApkversions qzAppApkversions);

    Result getInfo(String id);

    Result remove(String id);
}
