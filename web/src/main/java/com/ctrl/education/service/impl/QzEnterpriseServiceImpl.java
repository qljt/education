package com.ctrl.education.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.ExcelUtils;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.QzEnterpriseMapper;
import com.ctrl.education.dto.QzEnterpriseDto;
import com.ctrl.education.model.QzEnterprise;
import com.ctrl.education.service.IQzEnterpriseService;
import com.ctrl.education.shiro.ShiroKit;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
        String enterpriseName = (String) params.get("enterprise_name");
        Page<QzEnterprise> page = this.selectPage(
                new Query<QzEnterprise>(params).getPage(),
                new EntityWrapper<QzEnterprise>()
                        .like(StringUtils.isNotBlank(enterpriseName), "enterprise_name", enterpriseName)
                        .orderBy("createtime", true)
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
    public Result save(QzEnterprise qzEnterprise) {
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        qzEnterprise.setId(uuid);
        qzEnterprise.setCreatetime(DateUtil.now());
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
    public Result getEnterpriseById(Integer id) {
        QzEnterprise qzEnterprise = this.baseMapper.selectById(id);
        return Result.ok().put("qzEnterprise", qzEnterprise);
    }

    /**
     * 修改用户
     * @param qzEnterprise
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result update(QzEnterprise qzEnterprise) {
        Integer count = this.baseMapper.updateById(qzEnterprise);
        if (count > 0) {
            return Result.ok(SystemConstant.ADD_SUCCESS);
        } else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }

    /**
     * 删除企业信息，多个id
     * @param ids
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(String[] ids) {
        boolean bool = this.deleteBatchIds(Arrays.asList(ids));
        if(bool){
            return Result.ok("删除成功");
        }else {
            return Result.ok("删除失败");
        }
    }

    @Override
    public Result importExcel(String url) {
        QzEnterpriseDto qzEnterpriseDto = new QzEnterpriseDto();
        qzEnterpriseDto.setSysUserId(String.valueOf(ShiroKit.getUser().getId()));
        List list = ExcelUtils.importExcel(url,1,1, QzEnterpriseDto.class);
        if(null!=list&&list.size()>0){
            return Result.ok("导入成功");
        }else{
            return Result.ok("导入失败");
        }
    }
}