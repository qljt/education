package com.ctrl.education.service.impl;

import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzEnterpriseSetting;
import com.ctrl.education.dao.QzEnterpriseSettingMapper;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.service.IQzEnterpriseSettingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.shiro.ShiroKit;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return Result.ok().put("qzEnterpriseSetting", qzEnterpriseSetting);
    }

    @Override
    public Result save(QzEnterpriseSetting qzEnterpriseSetting) {
        SysUser sysUser = ShiroKit.getUser();
        qzEnterpriseSetting.setSysUserId(sysUser.getId());
        boolean flag = this.insertOrUpdate(qzEnterpriseSetting);
        if (flag) {
            return Result.ok(SystemConstant.ADD_SUCCESS);
        } else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }

    @Override
    public Result getSettingInfo(String enterprise_id) {
        Map<String,Object> map = new HashMap<>();
        map.put("enterprise_id",enterprise_id);
        List<QzEnterpriseSetting> list = this.selectByMap(map);
        return Result.ok().put("result",list.get(0));
    }
}
