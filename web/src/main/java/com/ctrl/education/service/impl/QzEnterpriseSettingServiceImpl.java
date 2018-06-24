package com.ctrl.education.service.impl;

import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzEnterpriseSetting;
import com.ctrl.education.dao.QzEnterpriseSettingMapper;
import com.ctrl.education.service.IQzEnterpriseSettingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 企业信息配置表 服务实现类
 * </p>
 *
 * @author liyang
 * @since 2018-06-04
 */
@Service
public class QzEnterpriseSettingServiceImpl extends ServiceImpl<QzEnterpriseSettingMapper, QzEnterpriseSetting> implements IQzEnterpriseSettingService {
    @Override
    public Result getQZEntSettingById(Integer id) {
        QzEnterpriseSetting qzEnterpriseSetting = this.selectById(id);
        return Result.ok().put("qzEnterpriseSetting",qzEnterpriseSetting);
    }

    @Override
    public Result save(QzEnterpriseSetting qzEnterpriseSetting) {
       boolean flag =  this.insertOrUpdate(qzEnterpriseSetting);
        if (flag) {
            return Result.ok(SystemConstant.ADD_SUCCESS);
        } else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }
}
