package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.dao.QzPaperQuestionTypeMapper;
import com.ctrl.education.model.QzPaperQuestionType;
import com.ctrl.education.service.IQzPaperFixedService;
import com.ctrl.education.service.IQzPaperQuestionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 试卷题型表 服务实现类
 * </p>
 *
 * @author liyang_1
 * @since 2018-07-23
 */
@Service
public class QzPaperQuestionTypeServiceImpl extends ServiceImpl<QzPaperQuestionTypeMapper, QzPaperQuestionType> implements IQzPaperQuestionTypeService {
    @Override
    public Result add(QzPaperQuestionType qzPaperQuestionType) {
        ValidatorUtils.validateEntity(qzPaperQuestionType);
        if (qzPaperQuestionType.getId() == null) {
            List<QzPaperQuestionType> qzPaperQuestionTypes = this.baseMapper.listByPaperId(qzPaperQuestionType.getPaperId(), qzPaperQuestionType.getAlias());
            if (qzPaperQuestionTypes.size() == 0) {
                int count = this.baseMapper.insert(qzPaperQuestionType);
                String id = qzPaperQuestionType.getId();
                if (count > 0) {
                    return Result.ok().put("msg", SystemConstant.ADD_SUCCESS).put("code", SystemConstant.SUCCESS).put("result", id);
                }
                return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
            }
            return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
    }
}
