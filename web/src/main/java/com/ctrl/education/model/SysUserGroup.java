package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author ctrl
 * @since 2018-07-31
 */
@TableName("sys_user_group")
public class SysUserGroup extends Model<SysUserGroup> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    @TableField("user_id")
    private String userId;
    @TableField("group_id")
    private String groupId;
    @TableField(exist = false)
    private List<SysUserGroup> sysUserGroupList;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<SysUserGroup> getSysUserGroupList() {
        return sysUserGroupList;
    }

    public void setSysUserGroupList(List<SysUserGroup> sysUserGroupList) {
        this.sysUserGroupList = sysUserGroupList;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "SysUserGroup{" +
                "id=" + id +
                ", userId=" + userId +
                ", groupId=" + groupId +
                "}";
    }
}
