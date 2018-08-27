package com.ctrl.education.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.QzQuestionBankMapper;
import com.ctrl.education.model.QzQuestionBank;
import com.ctrl.education.service.IQzQuestionBankService;
import com.ctrl.education.shiro.ShiroKit;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 题库表 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@Service
public class QzQuestionBankServiceImpl extends ServiceImpl<QzQuestionBankMapper, QzQuestionBank> implements IQzQuestionBankService {
    @Override
    public Result add(QzQuestionBank qzQuestionBank) {
        qzQuestionBank.setCode(String.valueOf(Integer.parseInt(this.baseMapper.selectMaxCode()) + 1));
        qzQuestionBank.setType(1);
        qzQuestionBank.setParentId(0);
        qzQuestionBank.setIsChild(1);
        qzQuestionBank.setState(1);
        qzQuestionBank.setCreatetime(DateUtil.now());
        qzQuestionBank.setSysUserId(ShiroKit.getUser().getId());
        qzQuestionBank.setIsPractice(0);
        qzQuestionBank.setEditPermissions(1);
        qzQuestionBank.setShareAdmin(0);
        qzQuestionBank.setUseStudent(0);
        if (qzQuestionBank.getId() == null) {
            int count = this.baseMapper.insert(qzQuestionBank);
            if (count > 0) {
                String id = qzQuestionBank.getId();
                return Result.ok().put("msg", SystemConstant.ADD_SUCCESS).put("code", SystemConstant.SUCCESS).put("result",id);
            }
            return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.ADD_FAILURE);
    }
}
