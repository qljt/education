package com.ctrl.education.service.impl;

import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysOffice;
import com.ctrl.education.dao.SysOfficeMapper;
import com.ctrl.education.service.ISysOfficeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 机构表 服务实现类
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
@Service
public class SysOfficeServiceImpl extends ServiceImpl<SysOfficeMapper, SysOffice> implements ISysOfficeService {
    @Override
    public Result  tree() {
        List<ZTreeNode> tree = this.baseMapper.tree();
        tree.add(ZTreeNode.createParent());
      return Result.ok().put("data",tree);
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result save(SysOffice sysOffice) {
        boolean flag = this.insert(sysOffice);
        if(flag){
            return Result.ok(SystemConstant.ADD_SUCCESS);
        }else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result modify(SysOffice sysOffice) {
        boolean flag = this.updateById(sysOffice);
        if(flag){
            return Result.ok(SystemConstant.UPDATE_SUCCESS);
        }else {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }
    @Transactional(
            rollbackFor = {Exception.class}
    )
    @Override
    public Result remove(String id) {
       boolean flag = this.deleteById(id);
       if(flag){
           return Result.ok(SystemConstant.DELETE_SUCCESS);
       }else {
           return Result.error(SystemConstant.DELETE_FAILURE);
       }
    }
}
