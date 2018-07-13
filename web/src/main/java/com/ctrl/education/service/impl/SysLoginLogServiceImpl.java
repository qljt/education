package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzSmsLog;
import com.ctrl.education.model.SysLoginLog;
import com.ctrl.education.dao.SysLoginLogMapper;
import com.ctrl.education.service.ISysLoginLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 登录日志 服务实现类
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
@Service
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements ISysLoginLogService {

    @Override
    public Result getList(Map<String, Object> param) {
        String start_time = (String) param.get("start_time");
        String end_time = (String) param.get("end_time");
        Page<SysLoginLog> page = this.selectPage(
                new Query<SysLoginLog>(param).getPage(),
                new EntityWrapper<SysLoginLog>()
                        .between(StringUtils.isNotBlank(start_time), "createtime", start_time, end_time)
                        .orderBy("createtime", true));
        return new PageUtils(page).toLayTableResult();
    }
}
