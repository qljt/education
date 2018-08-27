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
    private String pid;
    /**
     * 所有父级id的集合，逗号隔开
     */
    private String pids;
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * 类型1.部门 2.单位
     */
    private Integer type;
    /**
     * 状态，1：启用，0：禁用，3：删除
     */
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
    /**
     * 机构性质
     */
    @TableField("office_nature")
    private String officeNature;
    /**
     * 是否虚拟机构 1:是0否
     */
    @TableField("is_virtual")
    private Integer isVirtual;
    /**
     * 所属行业
     */
    @TableField("sys_industry")
    private String sysIndustry;
    /**
     * 所处政区
     */
    @TableField("sys_region")
    private String sysRegion;
    /**
     * 人数
     */
    @TableField("person_count")
    private Integer personCount;

    /**
     * 排序值
     */
    @TableField("sort")
    private Integer sort;

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

    public String getOfficeNature() {
        return officeNature;
    }

    public void setOfficeNature(String officeNature) {
        this.officeNature = officeNature;
    }

    public Integer getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(Integer isVirtual) {
        this.isVirtual = isVirtual;
    }

    public String getSysIndustry() {
        return sysIndustry;
    }

    public void setSysIndustry(String sysIndustry) {
        this.sysIndustry = sysIndustry;
    }

    public String getSysRegion() {
        return sysRegion;
    }

    public void setSysRegion(String sysRegion) {
        this.sysRegion = sysRegion;
    }

    public Integer getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
                ", officeNature=" + officeNature +
                ", isVirtual=" + isVirtual +
                ", sysIndustry=" + sysIndustry +
                ", sysRegion=" + sysRegion +
                ", personCount=" + personCount +
                ", sort=" + sort +
                "}";
    }
}
