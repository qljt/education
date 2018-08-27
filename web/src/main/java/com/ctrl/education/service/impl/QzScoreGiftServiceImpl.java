package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.AlohaDateUtils;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.model.QzGiftOrders;
import com.ctrl.education.model.QzScoreGift;
import com.ctrl.education.dao.QzScoreGiftMapper;
import com.ctrl.education.service.IQzScoreGiftService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.shiro.ShiroKit;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * <p>
 * 积分兑换礼品表 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@Service
public class QzScoreGiftServiceImpl extends ServiceImpl<QzScoreGiftMapper, QzScoreGift> implements IQzScoreGiftService {
    @Override
    public Result getList(Map<String, Object> map) {
        String name = (String) map.get("name");
        Page<QzScoreGift> page = this.selectPage(
                new Query<QzScoreGift>(map).getPage(),
                new EntityWrapper<QzScoreGift>()
                        .like(StringUtils.isNotBlank(name), "name", name)
                        .ne("state", 0)
                        .orderBy("createtime", false)
        );
        return new PageUtils(page).toLayTableResult();
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result save(QzScoreGift qzScoreGift) {
        ValidatorUtils.validateEntity(qzScoreGift, AddGroup.class);
        qzScoreGift.setCreatetime(AlohaDateUtils.getDay());
        qzScoreGift.setLastUpdateTime(AlohaDateUtils.getDay());
        qzScoreGift.setSysUserId(ShiroKit.getUser().getId());
        boolean flag = this.insert(qzScoreGift);
        if (flag) {
            return Result.ok(SystemConstant.ADD_SUCCESS);
        } else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }

    @Override
    @Transactional
            (rollbackFor = {Exception.class})
    public Result modify(QzScoreGift qzScoreGift) {
        if (StringUtils.isEmpty(qzScoreGift.getId())) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        ValidatorUtils.validateEntity(qzScoreGift, UpdateGroup.class);
        qzScoreGift.setLastUpdateTime(AlohaDateUtils.getDay());
        qzScoreGift.setSysUserId(ShiroKit.getUser().getId());
        boolean flag = this.updateById(qzScoreGift);
        if (flag) {
            return Result.ok(SystemConstant.UPDATE_SUCCESS);
        } else {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }

    @Override
    public Result remove(String id) {
        if (StringUtils.isEmpty(id)) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        int count = baseMapper.remove(id);
        if (count > 0) {
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        } else {
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }

    @Override
    public Result getInfo(String id) {
        if (StringUtils.isEmpty(id)) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        QzScoreGift qzScoreGift = this.selectById(id);
        return Result.ok().put(SystemConstant.RESULT_KEY, qzScoreGift);
    }
}
