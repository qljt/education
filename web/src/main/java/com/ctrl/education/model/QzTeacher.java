package com.ctrl.education.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.ctrl.education.core.validator.group.AddGroup;
import com.ctrl.education.core.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 教师表
 * </p>
 *
 * @author ${author}
 * @since 2018-07-20
 */
@TableName("qz_teacher")
public class QzTeacher extends Model<QzTeacher> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 名称
     */
    @TableField("name")
    @NotNull(message = "教师不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 30, message = "教师名称长度为1-30。", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    /**
     * 教师等级ID
     */
    @TableField("tea_type_id")
    private String teaTypeId;
    /**
     * 账号
     */
    @NotNull(message = "账号不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 1, max = 30, message = "账号长度为1-30。", groups = {AddGroup.class, UpdateGroup.class})
    private String account;
    /**
     * 密码
     */
    @NotNull(message = "密码不可为空", groups = {AddGroup.class, UpdateGroup.class})
    @Length(min = 6, max = 30, message = "账号长度为6-30。", groups = {AddGroup.class, UpdateGroup.class})
    private String password;
    /**
     * 头像
     */
    private String icon;
    /**
     * 资历简介
     */
    private String seniority;
    /**
     * 详细介绍
     */
    private String content;
    /**
     * 头衔介绍
     */
    @Length(max =500, message = "头衔最大长度为500", groups = {AddGroup.class, UpdateGroup.class})
    @TableField("tea_title")
    private String teaTitle;
    /**
     * 系统编码
     */
    @TableField("sys_code")
    private String sysCode;
    /**
     * 状态 0删除 1正常 2禁用
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeaTypeId() {
        return teaTypeId;
    }

    public void setTeaTypeId(String teaTypeId) {
        this.teaTypeId = teaTypeId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTeaTitle() {
        return teaTitle;
    }

    public void setTeaTitle(String teaTitle) {
        this.teaTitle = teaTitle;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
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
        return "QzTeacher{" +
        "id=" + id +
        ", name=" + name +
        ", teaTypeId=" + teaTypeId +
        ", account=" + account +
        ", password=" + password +
        ", icon=" + icon +
        ", seniority=" + seniority +
        ", content=" + content +
        ", teaTitle=" + teaTitle +
        ", sysCode=" + sysCode +
        ", state=" + state +
        ", sysUserId=" + sysUserId +
        "}";
    }
}
