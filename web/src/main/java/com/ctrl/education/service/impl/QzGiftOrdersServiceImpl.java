package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.QzGiftOrdersMapper;
import com.ctrl.education.model.QzGiftOrders;
import com.ctrl.education.service.IQzGiftOrdersService;
import com.ctrl.education.shiro.ShiroKit;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 兑换记录 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-15
 */
@Service
public class QzGiftOrdersServiceImpl extends ServiceImpl<QzGiftOrdersMapper, QzGiftOrders> implements IQzGiftOrdersService {
    @Override
    public Result getList(Map<String, Object> map) {
        String account = (String) map.get("account");
        String depart_id = (String) map.get("departId");
        String status = (String) map.get("status");
        String giftName = (String) map.get("giftName");
        String starTime = (String) map.get("startTime");
        String endTime = (String) map.get("endTime");
        Page<QzGiftOrders> page = this.selectPage(
                new Query<QzGiftOrders>(map).getPage(),
                new EntityWrapper<QzGiftOrders>()
                        .ne("state", 0)
                        .eq(StringUtils.isNotBlank(status), "status", status)
                        .eq(StringUtils.isNotBlank(depart_id), "depart_id", depart_id)
                        .like(StringUtils.isNotBlank(account), "account", account)
                        .like(StringUtils.isNotBlank(giftName), "gift_name", giftName)
                        .between(StringUtils.isNotBlank(starTime), "createtime", starTime, endTime)
                        .orderBy("createtime", true));

        return new PageUtils(page).toLayTableResult();
    }

    @Override
    public Result agree(QzGiftOrders qzGiftOrders) {
        String userId = ShiroKit.getUser().getId();
        qzGiftOrders.setSysUserId(userId);
        qzGiftOrders.setStatus(1);
        boolean flag = this.modify(qzGiftOrders);
        if (flag) {
            return Result.ok("兑换成功");
        } else {
            return Result.error("兑换失败");
        }
    }

    @Override
    public Result refuse(QzGiftOrders qzGiftOrders) {
        String userId = ShiroKit.getUser().getId();
        qzGiftOrders.setSysUserId(userId);
        qzGiftOrders.setStatus(2);
        boolean flag = this.modify(qzGiftOrders);
        if (flag) {
            return Result.ok("拒绝成功");
        } else {
            return Result.ok("拒绝失败");
        }
    }

    private boolean modify(QzGiftOrders qzGiftOrders) {
        boolean flag = this.updateById(qzGiftOrders);
        return flag;
    }
}
