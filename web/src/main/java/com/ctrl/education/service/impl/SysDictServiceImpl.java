package com.ctrl.education.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dto.SysDictDto;
import com.ctrl.education.model.SysDict;
import com.ctrl.education.dao.SysDictMapper;
import com.ctrl.education.service.ISysDictService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统字典表 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-07-21
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String typeId = (String) params.get("typeId");

        Page<SysDict> page = this.selectPage(
                new Query<SysDict>(params).getPage(),
                new EntityWrapper<SysDict>()
                        .eq("type_id", typeId)
                        // 根据排序字段正序排列
                        .orderBy("sort", true)
        );

        return new PageUtils(page);
    }

    @Override
    public boolean hasValue(Integer id, Integer typeId, String value) {
        int count = baseMapper.selectCount(
                new EntityWrapper<SysDict>()
                        .ne(ObjectUtil.isNotNull(id), "id", id)
                        .eq("type_id", typeId)
                        .eq("value", value)
        );
        if (count >= 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<SysDictDto> getDictsByTypeName(String typeName) {

        List<SysDictDto> dicts = baseMapper.getDictsByTypeName(typeName);

        return dicts;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result save(SysDict sysDict) {
        boolean flag = this.insert(sysDict);
        if (flag) {
            return Result.ok(SystemConstant.ADD_SUCCESS);
        } else {
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result modify(SysDict sysDict) {
        boolean flag = this.updateById(sysDict);
        if (flag) {
            return Result.ok(SystemConstant.UPDATE_SUCCESS);
        } else {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result remove(Integer id) {
        boolean flag = this.deleteById(id);
        if (flag) {
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        } else {
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }

    @Override
    public Result selectExamType() {
        List<SysDict> sysDictList = this.baseMapper.selectExamType();
        if (sysDictList.size() > 0) {
            return Result.ok().put("msg", SystemConstant.QUERY_SUCCESS).put("code", SystemConstant.SUCCESS).put("result", sysDictList);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.QUERY_FAILURE);
    }
}
