package com.ctrl.education.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.dao.SysDictMapper;
import com.ctrl.education.dto.SysDictDto;
import com.ctrl.education.model.SysDict;
import com.ctrl.education.service.ISysDictService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统字典表 服务实现类
 * </p>
 *
 * @author liyang
 * @since 2018-06-03
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

}
