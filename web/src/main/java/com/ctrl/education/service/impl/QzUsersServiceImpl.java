package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.utils.PageUtils;
import com.ctrl.education.core.utils.Query;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.QzUsersMapper;
import com.ctrl.education.dao.QzUsersScoreRecordMapper;
import com.ctrl.education.model.QzUsers;
import com.ctrl.education.model.QzUsersScoreRecord;
import com.ctrl.education.service.IQzUsersScoreRecordService;
import com.ctrl.education.service.IQzUsersService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-08-13
 */
@Service
public class QzUsersServiceImpl extends ServiceImpl<QzUsersMapper, QzUsers> implements IQzUsersService {
    @Override
    public Result selectUser(String departId) {
        String[] partIds = departId.split(",");
        List list = new ArrayList();
        for (int i = 0; i < partIds.length; i++) {
            List<QzUsers> qzUsersList = this.baseMapper.selectUsers(partIds[i]);
            list.add(qzUsersList);
        }
        if (list.size() > 0) {
            return Result.ok().put("msg", SystemConstant.QUERY_SUCCESS).put("code", SystemConstant.SUCCESS).put("result", list);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.QUERY_FAILURE);
    }

    @Override
    public Result getUserById(String id) {
        String[] arr = id.split(",");
        List<QzUsers> qzUsersList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String arrId = arr[i];
            QzUsers qzUsers = this.baseMapper.getUserById(arrId);
            qzUsersList.add(qzUsers);
        }
        if (qzUsersList.size() > 0) {
            return Result.ok().put("msg", SystemConstant.QUERY_SUCCESS).put("code", SystemConstant.SUCCESS).put("result", qzUsersList);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.QUERY_FAILURE);

    }
}
