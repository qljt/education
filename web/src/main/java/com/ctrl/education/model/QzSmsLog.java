package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 短信记录表
 * </p>
 *
 * @author liyang
 * @since 2018-06-20
 */
@TableName("qz_sms_log")
public class QzSmsLog extends Model<QzSmsLog> {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 短信内容
     */
    private String content;
    /**
     * 是否成功 0否 1是
     */
    @TableField("is_suc")
    private Integer isSuc;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsSuc() {
        return isSuc;
    }

    public void setIsSuc(Integer isSuc) {
        this.isSuc = isSuc;
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
        return "QzSmsLog{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", createtime='" + createtime + '\'' +
                ", content='" + content + '\'' +
                ", isSuc=" + isSuc +
                ", sysCode='" + sysCode + '\'' +
                '}';
    }
}
