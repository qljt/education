package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzIntegralRule;
import com.ctrl.education.dao.QzIntegralRuleMapper;
import com.ctrl.education.model.SysLog;
import com.ctrl.education.service.IQzIntegralRuleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * <p>
 * 积分规则表 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@Service
public class QzIntegralRuleServiceImpl extends ServiceImpl<QzIntegralRuleMapper, QzIntegralRule> implements IQzIntegralRuleService {
    @Override
    @Transactional(rollbackFor = Exception.class)

    public Result modify(QzIntegralRule qzIntegralRule) {
        boolean flag = this.updateById(qzIntegralRule);
        if (flag) {
            return Result.ok(SystemConstant.UPDATE_SUCCESS);
        } else {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }

    @Override
    public Result getList(Map<String, Object> map) {
        Page<QzIntegralRule> page = this.selectPage(
                new Query<QzIntegralRule>(map).getPage(),
                new EntityWrapper<QzIntegralRule>().ne("state",0));

        return new PageUtils(page).toLayTableResult();
    }
}
