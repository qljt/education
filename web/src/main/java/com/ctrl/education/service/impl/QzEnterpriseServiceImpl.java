package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.AlohaDateUtils;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.validator.ValidatorUtils;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import com.ctrl.education.dao.QzEnterpriseMapper;
import com.ctrl.education.model.QzEnterprise;
import com.ctrl.education.service.IQzEnterpriseService;
import com.ctrl.education.shiro.ShiroKit;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * <p>
 * 企业表 服务实现类
 * </p>
 *
 * @author liyang
 * @since 2018-06-03
 */
@Service
public class QzEnterpriseServiceImpl extends ServiceImpl<QzEnterpriseMapper, QzEnterprise> implements IQzEnterpriseService {
    /**
     * 分页获取企业信息
     *
     * @param params
     * @return Result
     */
    @Override
    public Result getList(Map<String, Object> params) {
        String enterprise_name = (String)params.get("enterprise_name");
        Page<QzEnterprise> page = this.selectPage(
                new Query<QzEnterprise>(params).getPage(),
                new EntityWrapper<QzEnterprise>()
                        .ne("state",3)
                        .like(StringUtils.isNotEmpty(enterprise_name), "enterprise_name", enterprise_name)
        );
        return new PageUtils(page).toLayTableResult();
    }

    /**
     * 保存
     *
     * @param qzEnterprise
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result add(QzEnterprise qzEnterprise) {
        ValidatorUtils.validateEntity(qzEnterprise, AddGroup.class);
        qzEnterprise.setCreatetime(AlohaDateUtils.getDay());
        qzEnterprise.setSysUserId(ShiroKit.getUser().getId());
        Integer count = this.baseMapper.insert(qzEnterprise);
        if (count > 0) {
            return Result.ok(SystemConstant.ADD_SUCCESS);
        } else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }

    /**
     * 根据id获取企业对象
     * @param id
     * @return
     */
    @Override
    public Result getEnterpriseById(String id) {
        if(StringUtils.isEmpty(id)){
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        QzEnterprise qzEnterprise = this.baseMapper.selectById(id);
        return Result.ok().put(SystemConstant.RESULT_KEY, qzEnterprise);
    }

    /**
     * 修改企业基本信息
     * @param qzEnterprise
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result modify(QzEnterprise qzEnterprise) {
        if(StringUtils.isEmpty(qzEnterprise.getId())){
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        ValidatorUtils.validateEntity(qzEnterprise, UpdateGroup.class);
        qzEnterprise.setSysUserId(ShiroKit.getUser().getId());
        Integer count = this.baseMapper.updateById(qzEnterprise);
        if (count > 0) {
            return Result.ok(SystemConstant.ADD_SUCCESS);
        } else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }

    /**
     * 删除企业信息
     * @param qzEnterprise
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(QzEnterprise qzEnterprise) {
        if(StringUtils.isEmpty(qzEnterprise.getId())){
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        qzEnterprise.setSysUserId(ShiroKit.getUser().getId());
        boolean bool = this.updateById(qzEnterprise);
        if(bool){
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        }else {
            return Result.ok(SystemConstant.DELETE_FAILURE);
        }
    }

    /**
     * 禁用启用
     * @param qzEnterprise
     * @return
     */
    @Override
    public Result disable(QzEnterprise qzEnterprise) {
        if(StringUtils.isEmpty(qzEnterprise.getId())){
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        qzEnterprise.setSysUserId(ShiroKit.getUser().getId());
        Integer state = qzEnterprise.getState();
        boolean flag = this.updateById(qzEnterprise);
        if (flag) {
            if(state==1){
                return Result.ok(SystemConstant.ENABLE_SUCCESS);
            }
            return Result.ok(SystemConstant.DISABLE_SUCCESS);
        } else {
            if(state==2){
                return Result.ok(SystemConstant.ENABLE_FAILURE);
            }
            return Result.error(SystemConstant.DISABLE_FAILURE);
        }
    }
}
