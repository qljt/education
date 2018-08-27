package com.ctrl.education.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.QzCouChapterMapper;
import com.ctrl.education.model.QzCouChapter;
import com.ctrl.education.service.IQzCouChapterService;
import com.ctrl.education.shiro.ShiroKit;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * 章表 服务实现类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
@Service
public class QzCouChapterServiceImpl extends ServiceImpl<QzCouChapterMapper, QzCouChapter> implements IQzCouChapterService {
    /**
     * 增加章
     *
     * @param qzCouChapter
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addChapter(QzCouChapter qzCouChapter) {
            qzCouChapter.setCreatetime(DateUtil.now());
            qzCouChapter.setSysCode(RandomUtil.randomString(4));
            qzCouChapter.setState(1);
            qzCouChapter.setSysUserId(ShiroKit.getUser().getId());
            int count = this.baseMapper.addChapter(qzCouChapter);
            if (count > 0) {
                String id = qzCouChapter.getId();
                if (!StringUtils.isEmpty(id)) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("msg", SystemConstant.ADD_SUCCESS);
                    map.put("code", SystemConstant.SUCCESS);
                    map.put("result", id);
                    return Result.ok(map);
                }else {
                    return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
                }
            }else {
                return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
            }
    }
}
