package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.QzPaperFixedMapper;
import com.ctrl.education.model.QzPaperFixed;
import com.ctrl.education.service.IQzPaperFixedService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 固定卷试卷题目表 服务实现类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
@Service
public class QzPaperFixedServiceImpl extends ServiceImpl<QzPaperFixedMapper, QzPaperFixed> implements IQzPaperFixedService {
    @Override
    public Result add(QzPaperFixed qzPaperFixed) {
        if (qzPaperFixed.getId() == null) {
            int count = this.baseMapper.insert(qzPaperFixed);
            if (count > 0) {
                return Result.ok().put("msg", SystemConstant.ADD_SUCCESS).put("code", SystemConstant.SUCCESS);
            }
            return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
    }
}
