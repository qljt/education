package com.ctrl.education.dto;

import com.ctrl.education.model.*;
import java.util.Date;
import java.util.List;

/**
 * com.ctrl.education.dto
 *
 * @name SysUserDto
 * @description
 * @date 2018-07-03 13:34
 */
public class SysUserDto {
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
    private Date createTime;
    /**
     * 最后登录时间
     */
    private Date lastLoginTime;
    private SysOffice sysOffice;
    private List<SysRole> sysRoles;
    private List<SysPost> sysPosts;
    private List<SysUserGroup> sysUserGroups;
    private SysDict sysDict;

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

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public SysOffice getSysOffice() {
        return sysOffice;
    }

    public void setSysOffice(SysOffice sysOffice) {
        this.sysOffice = sysOffice;
    }

    public List<SysRole> getSysRoles() {
        return sysRoles;
    }

    public void setSysRoles(List<SysRole> sysRoles) {
        this.sysRoles = sysRoles;
    }

    public List<SysPost> getSysPosts() {
        return sysPosts;
    }

    public void setSysPosts(List<SysPost> sysPosts) {
        this.sysPosts = sysPosts;
    }

    public List<SysUserGroup> getSysUserGroups() {
        return sysUserGroups;
    }

    public void setSysUserGroups(List<SysUserGroup> sysUserGroups) {
        this.sysUserGroups = sysUserGroups;
    }

    public SysDict getSysDict() {
        return sysDict;
    }

    public void setSysDict(SysDict sysDict) {
        this.sysDict = sysDict;
    }

    @Override
    public String toString() {
        return "SysUserDto{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                ", sysOffice=" + sysOffice +
                ", sysRoles=" + sysRoles +
                ", sysPosts=" + sysPosts +
                ", sysUserGroups=" + sysUserGroups +
                ", sysDict=" + sysDict +
                '}';
    }
}
