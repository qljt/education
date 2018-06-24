package com.ctrl.education.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author liyang
 * @since 2018-06-23
 */
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 性别，0保密（默认），1男，2女
     */
    private Integer gender;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 角色ID数组，逗号隔开
     */
    @TableField("role_id")
    private String roleId;
    /**
     * 座机号
     */
    private String phone;
    /**
     * 账号状态，1：启用，2：冻结 3：删除
     */
    private Integer status;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 机构id
     */
    @TableField("office_id")
    private String officeId;
    /**
     * 最后登录时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;
    public SysUser(){
    }
    public SysUser(SysUser sysUser){
        super();
        this.id = sysUser.getId();
        this.username = sysUser.getUsername();
        this.password = sysUser.getPassword();
        this.realname = sysUser.getRealname();
        this.nickname = sysUser.getRealname();
        this.avatar = sysUser.getAvatar();
        this.birthday = sysUser.getBirthday();
        this.gender = sysUser.getGender();
        this.email = sysUser.getEmail();
        this.mobile = sysUser.getEmail();
        this.phone = sysUser.getPhone();
        this.status = sysUser.getStatus();
        this.createTime = sysUser.getCreateTime();
        this.officeId = sysUser.getOfficeId();
        this.lastLoginTime = sysUser.getLastLoginTime();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        "id=" + id +
        ", username=" + username +
        ", password=" + password +
        ", realname=" + realname +
        ", nickname=" + nickname +
        ", avatar=" + avatar +
        ", birthday=" + birthday +
        ", gender=" + gender +
        ", email=" + email +
        ", mobile=" + mobile +
        ", roleId=" + roleId +
        ", phone=" + phone +
        ", status=" + status +
        ", createTime=" + createTime +
        ", officeId=" + officeId +
        ", lastLoginTime=" + lastLoginTime +
        "}";
    }
}
