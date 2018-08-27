package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.dao.QzPaperQuestionTypeMapper;
import com.ctrl.education.dao.QzPaperRandomMapper;
import com.ctrl.education.model.QzPaperQuestionType;
import com.ctrl.education.model.QzPaperRandom;
import com.ctrl.education.service.IQzPaperQuestionTypeService;
import com.ctrl.education.service.IQzPaperRandomService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 随机卷抽题规则表 服务实现类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
@Service
public class QzPaperRandomServiceImpl extends ServiceImpl<QzPaperRandomMapper, QzPaperRandom> implements IQzPaperRandomService {
    @Override
    public Result add(QzPaperRandom qzPaperRandom) {
        ValidatorUtils.validateEntity(qzPaperRandom);
        if (qzPaperRandom.getId() == null) {
            int count = this.baseMapper.insert(qzPaperRandom);
            if (count > 0) {
                return Result.ok().put("msg", SystemConstant.ADD_SUCCESS).put("code", SystemConstant.SUCCESS);
            }
            return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
    }
}
