package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.AlohaDateUtils;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzAppInterfaceLog;
import com.ctrl.education.dao.QzAppInterfaceLogMapper;
import com.ctrl.education.service.IQzAppInterfaceLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 接口访问日志 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
@Service
public class QzAppInterfaceLogServiceImpl extends ServiceImpl<QzAppInterfaceLogMapper, QzAppInterfaceLog> implements IQzAppInterfaceLogService {

    @Override
    public Result getList(Map<String, Object> param) {
        Map<String,Object> map =baseMapper.getChart(param);
        return Result.ok().put(SystemConstant.RESULT_KEY,map);
    }
}
