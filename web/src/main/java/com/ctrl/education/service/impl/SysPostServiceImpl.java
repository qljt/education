package com.ctrl.education.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ctrl.education.core.constant.SystemConstant;
import com.ctrl.education.core.node.ZTreeNode;
import com.ctrl.education.core.utils.Result;
import com.ctrl.education.dao.SysPostMapper;
import com.ctrl.education.model.SysPost;
import com.ctrl.education.service.ISysPostService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 岗位表 服务实现类
 * </p>
 *
 * @author ctrl
 * @since 2018-07-23
 */
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements ISysPostService {
    @Override
    public Result tree() {
        List<ZTreeNode> tree = this.baseMapper.tree();
        tree.add(ZTreeNode.createParent());
        return Result.ok().put(SystemConstant.RESULT_KEY, tree);
    }

    @Override
    public List<Map<String, Object>> getList(Map<String, Object> map) {
        String name = (String) map.get("name");
        List<Map<String, Object>> list = this.selectMaps(new EntityWrapper<SysPost>()
                .like(StringUtils.isNotBlank(name), "post_name", name));

        return list;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public Result save(SysPost sysPost) {
        if (StringUtils.isEmpty(sysPost.getPid()) || sysPost.getPid().equals(0)) {
            sysPost.setPid("0");
        }
        boolean flag = this.insert(sysPost);
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
    public Result modify(SysPost sysPost) {
        if (StringUtils.isEmpty(sysPost.getPid()) || sysPost.getPid().equals("0")) {
            sysPost.setPid("0");
        }
        boolean flag = this.updateById(sysPost);
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
    public Result remove(String id) {
        boolean flag = this.deleteById(id);
        if (flag) {
            return Result.ok(SystemConstant.DELETE_SUCCESS);
        } else {
            return Result.error(SystemConstant.DELETE_FAILURE);
        }
    }

    @Override
    public Map<String, Object> selectPostById(String id) {
        Map<String, Object> map =   baseMapper.selectPostById(id);
        return map;
    }

    @Override
    public List<ZTreeNode> postTreeList() {
        return baseMapper.postTreeList();
    }

    @Override
    public List<ZTreeNode> postTreeListByUserId(String userId) {
        return this.baseMapper.postTreeListByUserId(userId);
    }

    @Override
    public Result postSelect() {
        List<Map<String,Object>> list = this.baseMapper.postSelect();
        return Result.ok().put(SystemConstant.RESULT_KEY,list);
    }
}
