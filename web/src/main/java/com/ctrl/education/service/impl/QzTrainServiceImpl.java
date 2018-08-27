package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.QzTrainMapper;
import com.ctrl.education.dao.QzUsersMapper;
import com.ctrl.education.model.QzTeacher;
import com.ctrl.education.model.QzTrain;
import com.ctrl.education.model.QzUsers;
import com.ctrl.education.service.IQzTrainService;
import com.ctrl.education.service.IQzUsersService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 培训任务列表表 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@Service
public class QzTrainServiceImpl extends ServiceImpl<QzTrainMapper, QzTrain> implements IQzTrainService {
    @Override
    public Result list(Map<String, Object> map) {
        String name = (String) map.get("name");
        Page<QzTrain> page = this.selectPage(
                new Query<QzTrain>(map).getPage(),
                new EntityWrapper<QzTrain>()
                        .like(StringUtils.isNotBlank(name), "tr_name", name)
                        .ne(true, "state", 0));
        return new PageUtils(page).toLayTableResult();
    }
}
