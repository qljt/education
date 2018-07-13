package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.SysLogMapper;
import com.ctrl.education.model.SysLog;
import com.ctrl.education.model.SysLoginLog;
import com.ctrl.education.service.ISysLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author liyang
 * @since 2018-06-03
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {
    @Override
    public Result getList(Map<String, Object> map) {
        String type = (String)map.get("type");
        String username = (String)map.get("username");
        String start_time = (String)map.get("start_time");
        String end_time = (String)map.get("end_time");
        Page<SysLog> page = this.selectPage(
                new Query<SysLog>(map).getPage(),
                new EntityWrapper<SysLog>()
                        .eq(StringUtils.isNotBlank(type), "type", type)
                        .like(StringUtils.isNotBlank(username), "username", username)
                        .between(StringUtils.isNotBlank(start_time),"gmt_create",start_time,end_time)
                        .orderBy("gmt_create",true));

        return new PageUtils(page).toLayTableResult();
    }
}
