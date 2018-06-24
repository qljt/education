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
public class QzSmsLogServiceImpl extends ServiceImpl<QzSmsLogMapper, QzSmsLog> implements IQzSmsLogService {
    @Override
    public Result getList(Map<String, Object> map) {
        String phone = (String) map.get("phone");
        String is_suc = (String) map.get("is_suc");
        String start_time = (String)map.get("start_time");
        String end_time = (String)map.get("end_time");
        Page<QzSmsLog> page = this.selectPage(
                new Query<QzSmsLog>(map).getPage(),
                new EntityWrapper<QzSmsLog>()
                        .like(StringUtils.isNotBlank(is_suc), "phone", phone)
                        .eq("is_suc",is_suc).between("createtime",start_time,end_time));
        return new PageUtils(page).toLayTableResult();
    }
}
