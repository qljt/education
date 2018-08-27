package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.model.SysMenu;
import com.ctrl.education.model.SysOffice;
import com.ctrl.education.dao.SysOfficeMapper;
import com.ctrl.education.service.ISysOfficeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private SysOfficeMapper sysOfficeMapper;

    @Override
    public Result officeTree() {
        List<ZTreeNode> tree = this.baseMapper.officeTree();
        if (ToolUtils.isEmpty(tree)) {
            tree.add(ZTreeNode.createParent());
        }
        return Result.ok().put(SystemConstant.RESULT_KEY, tree);
    }

    @Override
    public Result deptTree() {
        List<Map<String, Object>> tree = this.baseMapper.deptTree();
        return Result.ok().put(SystemConstant.RESULT_KEY, tree);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Result save(SysOffice sysOffice) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", sysOffice.getCode());
        List<SysOffice> sysOffices = sysOfficeMapper.selectByMap(map);
        if (sysOffices.size() == 0) {
            boolean flag = this.insert(sysOffice);
            if (flag) {
                return Result.ok(SystemConstant.ADD_SUCCESS);
            } else {
                return Result.error(SystemConstant.ADD_FAILURE);
            }
        } else {
            return Result.error("编码:" + SystemConstant.QUERY_EXIST);
        }

    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result modify(SysOffice sysOffice) {
        boolean flag = this.updateById(sysOffice);
        if (flag) {
            return Result.ok(SystemConstant.UPDATE_SUCCESS);
        } else {
            return Result.error(SystemConstant.UPDATE_FAILURE);
        }
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    @Override
    public Result remove(String id) {
        if (StringUtils.isEmpty(id)) {
            return Result.error(SystemConstant.PARAM_NULL_ERROR);
        }
        List<Map<String, Object>> list = this.selectMaps(new EntityWrapper<SysOffice>()
                .where("pid={0}", id));
        if (ToolUtils.isNotEmpty(list)) {
            return Result.error(SystemConstant.EXSIT_CHILD_MENU);
        }
        boolean flag = this.deleteById(id);
        if (flag) {
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        } else {
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }

    @Override
    public List<Map<String, Object>> getList(Map<String, Object> map) {
        List<Map<String, Object>> list = baseMapper.getList(map);
        return list;
    }

    @Override
    public Map<String, Object> selectOfficeById(String id) {
        Map<String, Object> map = baseMapper.selectOfficeById(id);
        return map;
    }

    @Override
    public Result officeSelect() {
        List<Map<String, Object>> list = this.baseMapper.officeSelect();
        return Result.ok().put(SystemConstant.RESULT_KEY, list);
    }

    @Override
    public Result selectOfficeByType(Integer type) {
        List<SysOffice> sysOfficeList = this.baseMapper.selectOfficeByType(type);
        if (sysOfficeList.size() > 0) {
            return Result.ok().put("msg", SystemConstant.QUERY_SUCCESS).put("code", SystemConstant.SUCCESS).put("result", sysOfficeList);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.QUERY_FAILURE);
    }

    @Override
    public Result getDeptByCode(String code) {
        String[] arr = code.split(",");
        List<SysOffice> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String arrCode = arr[i];
            SysOffice sysOffice = this.baseMapper.getDeptByCode(arrCode);
            list.add(sysOffice);
        }
        if (list.size() > 0) {
            return Result.ok().put("msg", SystemConstant.QUERY_SUCCESS).put("code", SystemConstant.SUCCESS).put("result", list);
        }
        return Result.error(SystemConstant.ERROR_CODE, SystemConstant.QUERY_FAILURE);
    }
}


