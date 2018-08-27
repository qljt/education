package com.ctrl.education.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.model.SysDictType;
import com.ctrl.education.dao.SysDictTypeMapper;
import com.ctrl.education.model.SysOffice;
import com.ctrl.education.service.ISysDictTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements ISysDictTypeService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String) params.get("name");

        Page<SysDictType> page = this.selectPage(
                new Query<SysDictType>(params).getPage(),
                new EntityWrapper<SysDictType>()
                        .like(StringUtils.isNotBlank(name), "name", name)
                        // 根据排序字段正序排列
                        .orderBy("sort", true)
        );

        return new PageUtils(page);
    }

    @Override
    public boolean hasName(Integer id, String name) {
        int count = baseMapper.selectCount(
                new EntityWrapper<SysDictType>()
                        .ne(ObjectUtil.isNotNull(id), "id", id)
                        .eq("name", name)
        );
        if (count >= 1) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result save(SysDictType sysDictType) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", sysDictType.getName());
        List<SysDictType> list =this.selectByMap(map);
        if(ToolUtils.isNotEmpty(list)){
            return Result.error("类型名称已经存在");
        }
        boolean flag = this.insert(sysDictType);
        if (flag){
            return Result.ok(SystemConstant.ADD_SUCCESS);
        }else{
            return Result.error(SystemConstant.ADD_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result remove(Integer id) {
        boolean flag = this.deleteById(id);
        if (flag){
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        }else{
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result modify(SysDictType sysDictType) {
        boolean flag = this.updateById(sysDictType);
        if (flag){
            return Result.ok(SystemConstant.UPDATE_SUCCESS);
        }else{
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }
}
