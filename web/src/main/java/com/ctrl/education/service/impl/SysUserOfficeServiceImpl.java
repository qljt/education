package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.SysUserOffice;
import com.ctrl.education.dao.SysUserOfficeMapper;
import com.ctrl.education.service.ISysUserOfficeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 单位人员关联表 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-03
 */
@Service
public class SysUserOfficeServiceImpl extends ServiceImpl<SysUserOfficeMapper, SysUserOffice> implements ISysUserOfficeService {
    @Override
    public Result getList(Map<String, Object> map) {
        String sys_user_Id =(String) map.get("sys_user_id");
        if(StringUtils.isEmpty(sys_user_Id)){
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        List<Map<String, Object>> list = baseMapper.getList(map);
        Page<SysUserOffice> page = this.selectPage(
                new Query<SysUserOffice>(map).getPage(),
                new EntityWrapper<SysUserOffice>()
                        .eq("sys_user_id",sys_user_Id)
        );
        Integer totalCount = page.getRecords().size();
        return new Result().ok()
                .put("total", totalCount)
                .put("rows", list);
    }
}
