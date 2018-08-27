package com.ctrl.education.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.QzTestQuestionsMapper;
import com.ctrl.education.model.QzTestQuestions;
import com.ctrl.education.service.IQzTestQuestionService;
import com.ctrl.education.shiro.ShiroKit;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 试题表 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@Service
public class QzTestQuestionServiceImpl extends ServiceImpl<QzTestQuestionsMapper, QzTestQuestions> implements IQzTestQuestionService {
    @Override
    public Result add(QzTestQuestions qzTestQuestions) {
        qzTestQuestions.setState(1);
        qzTestQuestions.setStatus(1);
        qzTestQuestions.setCreateMan(ShiroKit.getUser().getId());
        qzTestQuestions.setCreatetime(DateUtil.now());
        if (qzTestQuestions.getId() == null) {
            int count = this.baseMapper.insert(qzTestQuestions);
            String id = qzTestQuestions.getId();
            if (count > 0) {
                return Result.ok().put("msg", SystemConstant.ADD_SUCCESS).put("code", SystemConstant.SUCCESS).put("result", id);
            }
            return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
    }
}
