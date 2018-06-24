package com.ctrl.education.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.dao.SysDictTypeMapper;
import com.ctrl.education.model.SysDictType;
import com.ctrl.education.service.ISysDictTypeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

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
}
