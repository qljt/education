package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzAppFeedback;
import com.ctrl.education.dao.QzAppFeedbackMapper;
import com.ctrl.education.model.QzSmsLog;
import com.ctrl.education.service.IQzAppFeedbackService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 系统反馈 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
@Service
public class QzAppFeedbackServiceImpl extends ServiceImpl<QzAppFeedbackMapper, QzAppFeedback> implements IQzAppFeedbackService {

    @Override
    public Result getList(Map<String, Object> map) {
        String account = (String) map.get("account");
        String is_suc = (String) map.get("isSuc");
        String startTime = (String)map.get("startTime");
        String endTime = (String)map.get("endTime");
        Page<QzAppFeedback> page = this.selectPage(
                new Query<QzAppFeedback>(map).getPage(),
                new EntityWrapper<QzAppFeedback>()
                        .like(StringUtils.isNotBlank(account), "account", account)
                        .eq(StringUtils.isNotBlank(is_suc),"is_suc",is_suc)
                        .between(StringUtils.isNotBlank(startTime),"createtime",startTime,endTime)
                        .orderBy("createtime",true));
        return new PageUtils(page).toLayTableResult();
    }
}
