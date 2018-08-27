package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzUsersScoreRecord;
import com.ctrl.education.dao.QzUsersScoreRecordMapper;
import com.ctrl.education.model.SysLog;
import com.ctrl.education.service.IQzUsersScoreRecordService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 用户积分记录 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@Service
public class QzUsersScoreRecordServiceImpl extends ServiceImpl<QzUsersScoreRecordMapper, QzUsersScoreRecord> implements IQzUsersScoreRecordService {
    @Override
    public Result getList(Map<String, Object> map) {
        String account = (String)map.get("account");
        String depart_id = (String)map.get("departId");
        String type = (String)map.get("type");
        String start_time = (String)map.get("startTime");
        String end_time = (String)map.get("endTime");
        Page<QzUsersScoreRecord> page = this.selectPage(
                new Query<QzUsersScoreRecord>(map).getPage(),
                new EntityWrapper<QzUsersScoreRecord>()
                        .eq(StringUtils.isNotBlank(type), "type", type)
                        .eq(StringUtils.isNotBlank(depart_id),"depart_id",depart_id)
                        .like(StringUtils.isNotBlank(account), "account", account)
                        .between(StringUtils.isNotBlank(start_time),"createtime",start_time,end_time)
                        .orderBy("createtime",true));

        return new PageUtils(page).toLayTableResult();
    }
}
