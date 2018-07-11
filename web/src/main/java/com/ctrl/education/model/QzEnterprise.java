package com.ctrl.education.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 企业表
 * </p>
 *
 * @since 2018-06-03
 */
@TableName("qz_enterprise")
public class QzEnterprise extends Model<QzEnterprise> {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    @TableField("enterprise_name")
    @NotNull(message = "企业名称不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 4, max = 190, message = "企业名称长度为4-190。", groups = {AddGroup.class, UpdateGroup.class})
    private String enterpriseName;
    /**
     * 系统编码（企业编码）
     */
    @TableField("sys_code")
    @Length(min = 4, max = 30, message = "企业编码长度为4-30。", groups = {AddGroup.class, UpdateGroup.class})
    private String sysCode;
    /**
     * 创建时间
     */
    private String createtime;
    /**
     * 联系人
     */
    @TableField("link_name")
    @Length(min = 4, max = 90, message = "联系人长度为4-90。", groups = {AddGroup.class, UpdateGroup.class})
    private String linkName;
    /**
     * 联系电话
     */
    @TableField("link_phone")
    @Length(min = 4, max = 30, message = "联系电话长度为4-30。", groups = {AddGroup.class, UpdateGroup.class})
    private String linkPhone;
    /**
     * 联系邮箱
     */
    @TableField("link_email")
    @Email(message = "邮箱格式有误。", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 4, max = 90, message = "联系电话长度为4-90。", groups = {AddGroup.class, UpdateGroup.class})
    private String linkEmail;
    /**
     * 公司介绍
     */
    private String content;
    /**
     * 状态  1启用 2禁用 3删除
     */
    private Integer state;
    /**
     * 编辑人员ID
     */
    @TableField("sys_user_id")
    private String sysUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getLinkEmail() {
        return linkEmail;
    }

    public void setLinkEmail(String linkEmail) {
        this.linkEmail = linkEmail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QzEnterprise{" +
                "id='" + id + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", sysCode='" + sysCode + '\'' +
                ", createtime='" + createtime + '\'' +
                ", linkName='" + linkName + '\'' +
                ", linkPhone='" + linkPhone + '\'' +
                ", linkEmail='" + linkEmail + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", sysUserId='" + sysUserId + '\'' +
                '}';
    }
}
