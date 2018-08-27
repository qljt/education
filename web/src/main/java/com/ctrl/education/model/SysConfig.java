package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统配置表
 * </p>
 *
 * @author ctrl
 * @since 2018-08-10
 */
@TableName("sys_config")
public class SysConfig extends Model<SysConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 系统名称
     */
    @TableField("system_name")
    private String systemName;
    /**
     * 版本号
     */
    @TableField("system_version")
    private String systemVersion;
    /**
     * 客服电话
     */
    @TableField("system_phone")
    private String systemPhone;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;


    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getSystemPhone() {
        return systemPhone;
    }

    public void setSystemPhone(String systemPhone) {
        this.systemPhone = systemPhone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysConfig{" +
        "systemName=" + systemName +
        ", systemVersion=" + systemVersion +
        ", systemPhone=" + systemPhone +
        ", id=" + id +
        "}";
    }
}
