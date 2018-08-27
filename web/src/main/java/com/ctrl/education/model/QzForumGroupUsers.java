package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 论坛小组成员
 * </p>
 *
 * @author ctrl
 * @since 2018-08-17
 */
@TableName("qz_forum_group_users")
public class QzForumGroupUsers extends Model<QzForumGroupUsers> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 小组ID
     */
    @TableField("group_id")
    private String groupId;
    /**
     * 用户ID
     */
    @TableField("users_id")
    private String usersId;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 状态 0删除 1正常 2禁用
     */
    private Integer state;
    /**
     * 系统编码
     */
    @TableField("sys_code")
    private String sysCode;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzForumGroupUsers{" +
        "id=" + id +
        ", groupId=" + groupId +
        ", usersId=" + usersId +
        ", createtime=" + createtime +
        ", state=" + state +
        ", sysCode=" + sysCode +
        "}";
    }
}
