package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.model.QzForumGroupUsers;
import com.ctrl.education.dao.QzForumGroupUsersMapper;
import com.ctrl.education.service.IQzForumGroupUsersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 论坛小组成员 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-17
 */
@Service
public class QzForumGroupUsersServiceImpl extends ServiceImpl<QzForumGroupUsersMapper, QzForumGroupUsers> implements IQzForumGroupUsersService {
    @Override
    public Result getQzusersByGroup(Map<String, Object> param) {
       String groupId = (String)param.get("groupId");
       if (StringUtils.isEmpty(groupId)){
           return Result.error(SystemConstant.PARAM_NULL_ERROR);
       }
        List<Map<String,Object>> list = baseMapper.getQzusersByGroup(param);
        Page<QzForumGroupUsers> page = this.selectPage(
                new Query<QzForumGroupUsers>(param).getPage(),
                new EntityWrapper<QzForumGroupUsers>()
                .eq("group_id",groupId)

        );
        Integer totalCount = Integer.parseInt(String.valueOf(page.getTotal()));
        return new Result().ok()
                .put("total", totalCount)
                .put("rows", list);
    }
}
