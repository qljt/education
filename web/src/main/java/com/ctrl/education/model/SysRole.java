package com.ctrl.education.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
@TableName("sys_role")
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 父级
     */
    private String pid;
    /**
     * 所有父级id的集合，逗号隔开
     */
    private String pids;
    /**
     * 角色名称
     */
    @NotNull(message = "角色不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 20, message = "长度为1-20。", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    /**
     * 组织架构id
     */
    @TableField("office_id")
    private String officeId;
    /**
     * 角色描述
     */
    private String desc;
    /**
     * 角色状态，1：禁用，2：启用，3；删除
     */
    private Integer status;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", pids='" + pids + '\'' +
                ", name='" + name + '\'' +
                ", officeId='" + officeId + '\'' +
                ", desc='" + desc + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
