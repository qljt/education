package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzSmsLog;
import com.ctrl.education.dao.QzSmsLogMapper;
import com.ctrl.education.model.SysUser;
import com.ctrl.education.service.IQzSmsLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 短信记录表 服务实现类
 * </p>
 *
 * @author liyang
 * @since 2018-06-20
 */
@Service
public class    QzSmsLogServiceImpl extends ServiceImpl<QzSmsLogMapper, QzSmsLog> implements IQzSmsLogService {
    @Override
    public Result getList(Map<String, Object> map) {
        String phone = (String) map.get("phone");
        String isSuc = (String) map.get("isSuc");
        String startTime = (String)map.get("startTime");
        String endTime = (String)map.get("endTime");
        Page<QzSmsLog> page = this.selectPage(
                new Query<QzSmsLog>(map).getPage(),
                new EntityWrapper<QzSmsLog>()
                        .like(StringUtils.isNotBlank(phone), "phone", phone)
                        .eq("is_suc",isSuc)
                        .between(StringUtils.isNotBlank(startTime),"createtime",startTime,endTime)
                        .orderBy("createtime",true));
        return new PageUtils(page).toLayTableResult();
    }
}
