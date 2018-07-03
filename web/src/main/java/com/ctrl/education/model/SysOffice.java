package com.ctrl.education.model;

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
 * 机构表
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
@TableName("sys_office")
public class SysOffice extends Model<SysOffice> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 父级id
     */
    @TableId("pid")
    private String pid;
    /**
     * 所有父级id的集合，逗号隔开
     */
    @TableId("pids")
    private String pids;
    /**
     * 名称
     */
    @TableId("name")
    @NotNull(message = "名称不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 4, max = 30, message = "长度为1-200。", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    /**
     * 编码
     */
    @TableId("code")
    @NotNull(message = "编码不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 4, max = 30, message = "编码长度为1-200。", groups = {AddGroup.class, UpdateGroup.class})
    private String code;
    /**
     * 类型
     */
    @TableId("type")
    private Integer type;
    /**
     * 状态，1：禁用，2：启用，3：删除
     */
    @TableId("status")
    private Integer status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 系统编码（企业编码）
     */
    @TableField("sys_code")
    private String sysCode;


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

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        return "SysOffice{" +
        "id=" + id +
        ", pid=" + pid +
        ", pids=" + pids +
        ", name=" + name +
        ", code=" + code +
        ", type=" + type +
        ", status=" + status +
        ", remark=" + remark +
        ", sysCode=" + sysCode +
        "}";
    }
}
