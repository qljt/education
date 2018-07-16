package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ctrl.education.core.constant.SysConstant;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.core.utils.ToolUtils;
import com.ctrl.education.model.SysDict;
import com.ctrl.education.dao.SysDictMapper;
import com.ctrl.education.model.SysMenu;
import com.ctrl.education.service.ISysDictService;
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
 * @author ${author}
 * @since 2018-07-15
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {
    @Override
    public Result getTreee() {
       List<ZTreeNode> list= baseMapper.getTree();
       return Result.ok().put(SystemConstant.RESULT_KEY,list);
    }

    @Override
    public List<Map<String,Object>> getList(Map<String, Object> param) {
        String name = (String)param.get("name");
        List<Map<String,Object> >list = this.selectMaps( new EntityWrapper<SysDict>()
                .like(StringUtils.isNotBlank(name), "name", name)
                .orderBy("sort", true));

        return list;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result save(SysDict sysDict) {
        if(hasCode(sysDict.getCode())){
            return Result.error("字典编码已经存在");
        }
        this.dictSetPid(sysDict);
        boolean flag = this.insert(sysDict);
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
    public Result modify(SysDict sysDict) {
        this.dictSetPid(sysDict);
        boolean flag = this.updateById(sysDict);
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
    public Result remove(String id) {
        if(StringUtils.isEmpty(id)){
            return Result.ok(SystemConstant.PARAM_ERROR);
        }
        boolean flag = this.deleteById(id);

        if(flag){
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        }else {
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }

    /**
     * 判断编码的唯一性
     * @param code
     * @return
     */
    private boolean hasCode(String code){
        Map<String,Object> map  = new HashMap<>();
        map.put("code",code);
        List<SysDict> list = this.baseMapper.selectByMap(map);
        if (ToolUtils.isNotEmpty(list)){
            return true;
        }
        return false;
    }
    /**
     * 根据请求的父级菜单编号设置pid和层级
     */
    private void dictSetPid(SysDict sysDict) {
        if (ToolUtils.isEmpty(sysDict.getPid()) || sysDict.getPid().equals("0")) {
            sysDict.setPid("0");
        }
    }
}
